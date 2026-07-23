package com.efd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void testGreeting() {
        assertEquals("Welcome to EFD Java with Gradle project!", App.getGreeting());
    }
}
