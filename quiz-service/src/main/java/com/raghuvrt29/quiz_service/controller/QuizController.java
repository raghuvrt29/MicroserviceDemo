package com.raghuvrt29.quiz_service.controller;

import com.raghuvrt29.quiz_service.model.QuestionWrapper;
import com.raghuvrt29.quiz_service.model.QuizDto;
import com.raghuvrt29.quiz_service.model.Response;
import com.raghuvrt29.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService service;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return service.createQuiz(quizDto.getTitle(), quizDto.getCategory(), quizDto.getNumQ());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return service.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitResponse(@PathVariable Integer id, @RequestBody List<Response> responses){
        return service.evaluateQuiz(id, responses);
    }

}
