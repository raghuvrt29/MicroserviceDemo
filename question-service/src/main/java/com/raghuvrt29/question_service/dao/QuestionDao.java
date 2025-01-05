package com.raghuvrt29.question_service.dao;

import com.raghuvrt29.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query("select q1_0 from Question q1_0")
    List<Question> findAllQuestions();

    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM questions q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
