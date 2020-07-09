package dev.sand.box.toolkit.service.testng;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DummyServiceImpl implements DummyService {
    private static final Logger LOG = LoggerFactory.getLogger(DummyServiceImpl.class);

    /**
     * @see DummyService#giveMeException4Test() for more information.
     */
    @Override
    public void giveMeException4Test() throws IOException {
        throw new IOException("Message for testing");
    }

    /**
     * @see DummyService#navigateFlow(boolean, boolean, boolean, boolean) for more information.
     */
    @Override
    public int navigateFlow(boolean firstControl, boolean secondControl, boolean isInside, boolean toBeRemoved) {
        int intValue = -1;
        if (firstControl) {
            LOG.info("firstControl");
            intValue = 1;
            if (toBeRemoved) {
                LOG.info("toBeRemoved");
                if (isInside) {
                    LOG.info("isInside");
                    intValue = 3;
                } else {
                    LOG.info("else isInside");
                    intValue = 4;
                }
            }
        } else if (secondControl) {
            LOG.info("secondControl");
            intValue = 2;
        }
        return intValue;
    }
}
