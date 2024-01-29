package com.jason.workoutScheduler.records;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class testRecords {

    @Test
    public void testCreateRecord() {
        Exercise exercise = new Exercise(
                UUID.randomUUID().toString(),
                "running",
                "run in place on a treadmill",
                "1",
                "30"
        );
        assertNotNull(exercise);
        assertEquals("running", exercise.name());
        assertEquals("30", exercise.timeInMins());
        assertTrue(exercise.getClass().isRecord());
        assertEquals(5, exercise.getClass().getRecordComponents().length);
    }
}
