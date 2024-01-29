package com.jason.workoutScheduler.repository;

import com.jason.workoutScheduler.records.Exercise;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ExerciseRepository {

    private List<Exercise> exercises;

    public ExerciseRepository() {
        exercises = Arrays.asList(
                new Exercise(UUID.randomUUID().toString(), "running", "running on a treadmill", "1", "30"),
                new Exercise(UUID.randomUUID().toString(), "deadlift", "barbell deadlift", "3", "20")
        );
    }

    public List<Exercise> getAll() {
        return exercises;
    }

    public Exercise getExerciseById(String id) {
        return exercises
                .stream()
                .filter(exercise -> exercise.id().equals(id)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Exercise not found"));
    }

    public Exercise createExercise(Exercise newExercise) {
        exercises.add(newExercise);
        return newExercise;
    }

    public void updateExercise(String id, Exercise updatedExercise) {
        Exercise exercise = getExerciseById(id);
        int index = exercises.indexOf(exercise);
        exercises.set(index, updatedExercise);
    }

    public void deleteExercise(String id) {
        exercises
                .stream()
                .filter(exercise -> !exercise.id().equals(id))
                .toList();
    }
}
