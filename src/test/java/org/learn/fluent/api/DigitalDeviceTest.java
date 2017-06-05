package org.learn.fluent.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DigitalDeviceTest
{
    @Test
    @Tag("sanity")
    @DisplayName("Verifies that a Digital device created is in valid state for business logic")
    void digitalDeviceCreatedIsInValidState()
    {
        MacBook macBook = new MacBook().manufactoredOn(LocalDateTime.now())
                                       .withRAM(16)
                                       .withCPU("Quad Code i9 10Ghz")
                                       .withGPU("Quad Code NVdia GForce 10Ghz")
                                       .withStorage(1024)
                                       .withDisplay("27-inch retina display");

        assertAll("Digital device state is invalid",
                  () -> { assertNotNull(macBook.getType());},
                  () -> { assertNotNull(macBook.getManufacturingDate());},
                  () -> { assertNotNull(macBook.getDisplaySpec());},
                  () -> { assertNotNull(macBook.getCpuSpec());},
                  () -> { assertNotNull(macBook.getGpuSpec());},
                  () -> { assertNotNull(macBook.getRamInGB());});
    }
}
