package com.adekah.mypetproject.service;

import com.adekah.mypetproject.dto.QuestionDto;
import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.entity.Answer;

public interface QuestionService {
    QuestionDto create(QuestionDto question);

    QuestionDto getById(Long id);

    Boolean delete(Long id);
}
