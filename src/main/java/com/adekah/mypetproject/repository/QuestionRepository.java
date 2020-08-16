package com.adekah.mypetproject.repository;

import com.adekah.mypetproject.dto.QuestionDto;
import com.adekah.mypetproject.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Long> {

}
