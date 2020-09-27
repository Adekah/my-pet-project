package com.adekah.mypetproject.service;

import com.adekah.mypetproject.dto.QuestionDto;
import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.entity.Answer;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> create(List<QuestionDto> question);

    QuestionDto getById(Long id);

    Boolean delete(Long id);
}
