package com.wooga.snyk

import spock.lang.Specification

class GradleInitSpec extends Specification {

    def "creates temp file with init script content"() {
        when:
        def r = GradleInit.getSnykInitScript()

        then:
        r != null
        r.text == getSnykInitScript()
    }

    static String getSnykInitScript() {
        def out
        try {
            InputStream is = GradleInit.class.getResourceAsStream("/snyk/snyk_init.gradle")
            out = is.getText()
        } catch (NullPointerException e) {
            throw new FileNotFoundException("File " + "snyk/snyk_init.gradle" + " was not found inside JAR.");
        }
        out
    }
}
