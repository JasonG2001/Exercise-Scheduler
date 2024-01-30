package com.jason.workoutScheduler.controller;

import com.jason.workoutScheduler.records.Exercise;
import com.jason.workoutScheduler.repository.ExerciseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private final ExerciseRepository exerciseRepository;

    public ExerciseController(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseRepository.getAll();
    }

    @GetMapping("/{id}")
    public Exercise getExerciseById(@PathVariable final String id) {
        return exerciseRepository.getExerciseById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Exercise postExercise(@RequestBody Exercise exercise) {
        return exerciseRepository.createExercise(exercise);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateExercise(@PathVariable final String id, @RequestBody Exercise exercise) {
        exerciseRepository.updateExercise(id, exercise);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        exerciseRepository.deleteExercise(id);
    }
}
