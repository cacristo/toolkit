package dev.sand.box.toolkit.service.testng;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class DummyServiceTest {

    @InjectMocks
    private DummyServiceImpl dummyService;

    @DataProvider
    public static Object[][] navigationFlow() {
        return new Object[][]{
                {"Scenario 'firstControl A1'", true, false, false, false, 1},
                {"Scenario 'firstControl A2'", true, true, false, false, 1},
                {"Scenario 'firstControl A3'", true, false, true, false, 1},
                {"Scenario 'isInside'", true, true, true, true, 3},
                {"Scenario 'else isInside'", true, true, false, true, 4},
                {"Scenario 'secondControl'", false, true, false, false, 2}
        };
    }

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(dataProvider = "navigationFlow")
    public void testNavigateFlow(String message, boolean firstControl, boolean secondControl, boolean isInside, boolean toBeRemoved, int expectedFlow) {
        int flowResult = dummyService.navigateFlow(firstControl, secondControl, isInside, toBeRemoved);
        assertEquals(flowResult, expectedFlow, message);
    }

    @Test(expectedExceptions = IOException.class, expectedExceptionsMessageRegExp = "Message for testing")
    public void testExceptions() throws IOException {
        dummyService.giveMeException4Test();
    }
}
