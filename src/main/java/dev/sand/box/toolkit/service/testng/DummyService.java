package dev.sand.box.toolkit.service.testng;

import java.io.IOException;

public interface DummyService {
    void giveMeException4Test() throws IOException;

    int navigateFlow(boolean firstControl, boolean secondControl, boolean isInside, boolean toBeRemoved);
}
