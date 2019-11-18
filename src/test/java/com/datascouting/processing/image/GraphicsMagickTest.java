package com.datascouting.processing.image;

import com.datascouting.processing.image.constant.Defaults;
import com.datascouting.processing.image.model.GraphicsMagickOption;
import com.datascouting.processing.image.utils.TestResourceLoader;
import io.vavr.collection.List;
import io.vavr.control.Try;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

/**
 * @author Chrisostomos Bakouras
 * @author Michailidis Michael
 */
public class GraphicsMagickTest {

    private Path binary;
    private Path testImage;
    private File testResultFile;

    @Before
    public void setUp() throws Exception {
        final TestResourceLoader testResourceLoader = new TestResourceLoader();

        this.binary = testResourceLoader
                .getBinary()
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);

        this.testImage = testResourceLoader
                .getTestImagePath()
                .getOrElseThrow((Function<Throwable, RuntimeException>) RuntimeException::new);

        this.testResultFile = File.createTempFile("test", ".png");
        this.testResultFile.deleteOnExit();
    }

    @Test
    public void testConvertWindows() throws IOException {
        assumeTrue(System.getProperty("os.name").toLowerCase().startsWith("win"));

        final GraphicsMagick gm = new GraphicsMagick(binary);

        final Try<File> convert = gm.convert(
                List.of(GraphicsMagickOption.thumbnail(50, 7)),
                this.testImage.toFile(),
                List.empty(),
                this.testResultFile
        );

        assertTrue(convert.isSuccess());

        final File file = convert.get();

        assertTrue(file.exists());
    }

    @Test
    @Ignore
    public void testConvertUnix() throws IOException {
        assumeFalse(System.getProperty("os.name").toLowerCase().startsWith("win"));

        final GraphicsMagick gm = new GraphicsMagick();

        final Try<File> convert = gm.convert(
                List.of(GraphicsMagickOption.thumbnail(50, 7)),
                this.testImage.toFile(),
                List.empty(),
                this.testResultFile
        );

        assertTrue(convert.isSuccess());

        final File file = convert.get();

        assertTrue(file.exists());
    }

    @Test
    public void testBinaryWithNoArgsConstructor() {
        final GraphicsMagick graphicsMagick = new GraphicsMagick();
        final Path binary = graphicsMagick.getBinary();

        assertEquals(Defaults.GraphicsMagickBinaryPath, binary);
    }

    @Test
    public void testBinaryWithArgsConstructor() {
        final Path expected = Paths.get("test");
        final GraphicsMagick graphicsMagick = new GraphicsMagick(expected);
        final Path binary = graphicsMagick.getBinary();

        assertEquals(expected, binary);
    }
}
