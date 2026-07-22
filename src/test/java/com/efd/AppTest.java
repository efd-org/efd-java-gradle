package com.efd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    public void testGreeting() {
        assertEquals("Hello, World!", App.getGreeting());
    }
}
