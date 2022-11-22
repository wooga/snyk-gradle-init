package com.wooga.snyk

import org.apache.commons.io.FileUtils

import java.nio.file.Files
import java.nio.file.StandardCopyOption

class GradleInit {
    /**
     * A temp solution to support buildScript dependency reporting.
     * <p>
     * We construct a custom init script which will override the init-script passed by snyk-cli to gradle to fetch
     * the dependencies and inject the buildScript `classpath` configuration along the other selected configurations.
     * This should be fixed and supported by snyk itself. I will open a support ticket.
     *
     * @return a {@code File} object pointing to the custom init script file.
     */
    static File getSnykInitScript() {
        File tempInitScript = File.createTempFile("snyk_gradle_init", ".gradle")
        String name = "/snyk/snyk_init.gradle"
        try {
            InputStream is = GradleInit.class.getResourceAsStream(name)
            Files.copy(is, tempInitScript.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            FileUtils.forceDelete(tempInitScript);
            throw e;
        } catch (NullPointerException e) {
            FileUtils.forceDelete(tempInitScript);
            throw new FileNotFoundException("File " + name + " was not found inside JAR.");
        }
        tempInitScript
    }
}
