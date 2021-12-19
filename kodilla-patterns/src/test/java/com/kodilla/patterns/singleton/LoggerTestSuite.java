package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger lastLog;

    @BeforeAll
    public static void createInstance() {
        lastLog = Logger.INSTANCE;
        lastLog.log("Instance was created");
    }

    @Test
    void testLastLog() {
        //given
        lastLog.log("First log");
        //when
        String log = lastLog.getLastLog();
        //then
        assertEquals("First log", log);

    }
}
