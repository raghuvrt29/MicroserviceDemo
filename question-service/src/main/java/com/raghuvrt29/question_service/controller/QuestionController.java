package com.raghuvrt29.question_service.controller;

import com.raghuvrt29.question_service.model.Question;
import com.raghuvrt29.question_service.model.QuestionWrapper;
import com.raghuvrt29.question_service.model.Response;
import com.raghuvrt29.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService service;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return service.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return service.addQuestion(question);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQ){
        return service.getQuestionsForQuiz(category,numQ);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuesionsById(@RequestBody List<Integer> questionIds){
        return service.getQuestionsById(questionIds);
    }

    @PostMapping("/getScore")
    public ResponseEntity<Integer> evaluateQuiz(@RequestBody List<Response> responses){
        return service.evaluateQuiz(responses);
    }

}
