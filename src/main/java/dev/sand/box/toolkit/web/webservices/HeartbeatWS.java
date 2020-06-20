package dev.sand.box.toolkit.web.webservices;

import dev.sand.box.toolkit.web.dto.SimpleResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Web Service to check the state of the API
 */
@RestController
@RequestMapping(value = "/is-alive")
public class HeartbeatWS {
    private static final Logger LOG = LoggerFactory.getLogger(HeartbeatWS.class);

    /**
     * Check if the API is alive.
     *
     * @return {@link ResponseEntity <String>}
     */
    @GetMapping
    public SimpleResponseDTO isAlive() {
        LOG.info("/is-alive");
        return new SimpleResponseDTO(200, "Toolkit API is alive!");
    }
}
