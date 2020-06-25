package dev.sand.box.toolkit.service.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * Introduction to TestNG framework
 */
public class BasicsOfTestNGTest {
    private static final Logger LOG = LoggerFactory.getLogger(BasicsOfTestNGTest.class);

    @BeforeTest
    public void setUp() {
        LOG.info("@BeforeTest");
    }

    @BeforeClass
    public void setClass() {
        LOG.info("@BeforeClass");
    }

    @BeforeMethod
    public void setMethod() {
        LOG.info("@BeforeMethod");
    }

    @AfterMethod
    public void destroyMethod() {
        LOG.info("@AfterMethod");
    }

    @AfterClass
    public void destroyClass() {
        LOG.info("@AfterClass");
    }

    @AfterTest
    public void destroy() {
        LOG.info("@AfterTest");
    }

    @Test
    public void givenSomething_whenMatch_thenOk() {
        LOG.info("Ordinary test1");
    }

    @Test(priority = 2)
    public void given_whenSunnyDay_thenParty() {
        LOG.info("Ordinary test2");
    }

    @Test(priority = 1, expectedExceptions = IOException.class, expectedExceptionsMessageRegExp = "This is an sample")
    public void givenABC_whenNumber_thenException() throws IOException {
        LOG.warn("expected exception");
        throw new IOException("This is an sample");
    }
}
