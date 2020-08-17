package com.adekah.mypetproject.repository;

import com.adekah.mypetproject.entity.Question;
import com.adekah.mypetproject.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByQuestionQuizId(Long id);

}
