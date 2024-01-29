package com.jason.workoutScheduler.records;

import java.time.LocalDateTime;

public record Workouts(String id, String name, String description, String sets, LocalDateTime time) {
}
