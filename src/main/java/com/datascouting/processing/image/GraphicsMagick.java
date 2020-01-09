package com.datascouting.processing.image;

import com.datascouting.processing.image.constant.Command;
import com.datascouting.processing.image.constant.Defaults;
import com.datascouting.processing.image.model.GraphicsMagickOption;
import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * @author Chrisostomos Bakouras
 */
public class GraphicsMagick {

    private static final String DELIMITER = " ";

    private static Logger logger = LoggerFactory.getLogger(GraphicsMagick.class);

    private final Path binary;

    public GraphicsMagick() {
        this.binary = Defaults.GraphicsMagickBinaryPath;
    }

    public GraphicsMagick(Path binary) {
        this.binary = Option.of(binary).getOrElse(Defaults.GraphicsMagickBinaryPath);
    }

    public Try<File> convert(final List<GraphicsMagickOption> inputOptions,
                             final File input,
                             final List<GraphicsMagickOption> outputOptions,
                             final File output) {
        requireNonNull(inputOptions, "inputOptions is null");
        requireNonNull(input, "input is null");
        requireNonNull(outputOptions, "outputOptions is null");
        requireNonNull(output, "output is null");

        return Try.of(() -> String
                .join(DELIMITER,
                        binary.toString(),
                        Command.CONVERT.toString(),
                        String.join(DELIMITER, inputOptions.map(GraphicsMagickOption::getValue)),
                        input.getAbsolutePath(),
                        String.join(DELIMITER, outputOptions.map(GraphicsMagickOption::getValue)),
                        output.getAbsolutePath()
                ))
                .flatMap(GraphicsMagick::execute)
                .map(ignored -> output);
    }

    public Try<File> convertPdfPage(final List<GraphicsMagickOption> inputOptions,
                                    final File input,
                                    final Integer pageNumber,
                                    final List<GraphicsMagickOption> outputOptions,
                                    final File output) {
        requireNonNull(inputOptions, "inputOptions is null");
        requireNonNull(input, "input is null");
        requireNonNull(pageNumber, "pageNumber is null");
        requireNonNull(outputOptions, "outputOptions is null");
        requireNonNull(output, "output is null");

        return Try.of(() -> String
                .join(DELIMITER,
                        binary.toString(),
                        Command.CONVERT.toString(),
                        String.join(DELIMITER, inputOptions.map(GraphicsMagickOption::getValue)),
                        input.getAbsolutePath() + "[" + pageNumber + "]",
                        String.join(DELIMITER, outputOptions.map(GraphicsMagickOption::getValue)),
                        output.getAbsolutePath()
                ))
                .flatMap(GraphicsMagick::execute)
                .map(ignored -> output);
    }

    public Try<String> identify(final List<GraphicsMagickOption> inputOptions,
                              final File input) {
        requireNonNull(inputOptions, "inputOptions is null");
        requireNonNull(input, "input is null");

        return Try.of(() -> String
                .join(DELIMITER,
                        binary.toString(),
                        Command.IDENTIFY.toString(),
                        String.join(DELIMITER, inputOptions.map(GraphicsMagickOption::getValue)),
                        input.getAbsolutePath()
                ))
                .flatMap(GraphicsMagick::execute);
    }

    private static Try<String> execute(final String command) {
        requireNonNull(command, "command is null");

        logger.debug(String.join(" ", command));

        return Try.of(() -> {
            final Process process = Runtime.getRuntime()
                    .exec(command);

            final String errOutput = new BufferedReader(new InputStreamReader(process.getErrorStream()))
                    .lines()
                    .collect(Collectors.joining("\n"));

            final String output = new BufferedReader(new InputStreamReader(process.getInputStream()))
                    .lines()
                    .collect(Collectors.joining("\n"));

            final int exitCode = process.waitFor();

            if (exitCode != 0) throw new RuntimeException("Error: " + errOutput);

            return output;
        });
    }

    public Path getBinary() {
        return binary;
    }
}
