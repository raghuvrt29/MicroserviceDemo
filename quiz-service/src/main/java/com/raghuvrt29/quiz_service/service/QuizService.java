package com.raghuvrt29.quiz_service.service;

import com.raghuvrt29.quiz_service.dao.QuizDao;
import com.raghuvrt29.quiz_service.feign.QuizInterface;
import com.raghuvrt29.quiz_service.model.Quiz;
import com.raghuvrt29.quiz_service.model.Response;
import com.raghuvrt29.quiz_service.model.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao dao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String title, String category, int numQ) {

        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        dao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Quiz quiz = dao.findById(id).get();
        List<QuestionWrapper> questionsForUser = quizInterface.getQuesionsById(quiz.getQuestionIds()).getBody();

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }

    public ResponseEntity<Integer> evaluateQuiz(Integer id, List<Response> responses) {

        int score = quizInterface.evaluateQuiz(responses).getBody();

        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
