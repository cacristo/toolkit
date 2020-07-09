package dev.sand.box.toolkit.service.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Introduction to TestNG framework
 */
public class BasicsOfTestNGTest {
    private static final Logger LOG = LoggerFactory.getLogger(BasicsOfTestNGTest.class);

    @Test(enabled = false)
    public void given_whenSunnyDay_thenParty() {
        LOG.info("Ordinary test2");
    }

    @Test(priority = 1)
    public void givenSomething_whenMatch_thenOk() {
        LOG.info("Match -> then Ok");
    }

    @Test(priority = 2)
    public void givenSomething_whenMatch_thenKo() {
        LOG.info("Match -> then Ko");
    }

    @Test(priority = 1)
    public void givenSomething_whenNoMatch_thenOk() {
        LOG.info("noMatch -> then Ok");
    }

    @Test(priority = 2)
    public void givenSomething_whenNoMatch_thenKo() {
        LOG.info("noMatch -> then Ko");
    }

    @Test(dependsOnMethods = {"givenSomething_whenMatch_thenKo", "givenSomething_whenNoMatch_thenKo"},
            expectedExceptions = IOException.class, expectedExceptionsMessageRegExp = "This is an sample")
    public void givenABC_whenNumber_thenException() throws IOException {
        LOG.warn("expected exception");
        throw new IOException("This is an sample");
    }
}
