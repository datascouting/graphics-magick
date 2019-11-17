package com.datascouting.processing.image.utils;

import io.vavr.control.Option;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.util.Objects.requireNonNull;

/**
 * @author Chrisostomos Bakouras
 */
public class TestResourceLoader {

    public static final String CONFIGURATION_NAME = "configuration.yml";
    public static final String TEST_IMAGE = "logo.png";

    public Try<Path> getTestImagePath() {
        return getResourcePath(TEST_IMAGE);
    }

    public Try<TestConfiguration> getConfiguration() {
        return getResourcePath(CONFIGURATION_NAME)
                .flatMap(configurationPath -> Try.of(() -> {
                    try (InputStream in = Files.newInputStream(configurationPath)) {
                        final Yaml yaml = new Yaml();
                        return yaml.loadAs(in, TestConfiguration.class);
                    }
                }));
    }

    private Try<Path> getResourcePath(final String resourcePath) {
        requireNonNull(resourcePath, "resourcePath is null");

        return Option.of(getClass())
                .map(Class::getClassLoader)
                .map(classLoader -> classLoader.getResource(resourcePath))
                .toTry()
                .flatMap(url -> Try.of(url::toURI))
                .flatMap(uri -> Try.of(() -> Paths.get(uri)));
    }

    public Try<Path> getBinary() {
        return getConfiguration()
                .map(TestConfiguration::getBinary)
                .map(path -> Paths.get(path));
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TestConfiguration {
        private String binary;
    }
}
