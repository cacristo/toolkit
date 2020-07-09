package dev.sand.box.toolkit.service.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Introduction to TestNG framework
 */
public class BasicsOfTestNGTest {
    private static final Logger LOG = LoggerFactory.getLogger(BasicsOfTestNGTest.class);

    @DataProvider
    public static Object[][] provider() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @Test(enabled = false)
    public void givenSomeTest_whenEnabledIsFalse_thenNeverBeExecuted() {
        LOG.info("This test will not be executed due '@Test(enabled = false)'");
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

    @Test(dataProvider = "provider")
    public void givenSomething_whenUsingProvider_thenOk(int value) {
        LOG.info("@Test with DataProvider {}", value);
    }
}
