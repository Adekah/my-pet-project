package com.adekah.mypetproject.service;

import com.adekah.mypetproject.dto.AnswerDto;
import com.adekah.mypetproject.dto.QuizDto;

import java.util.List;

public interface AnswerService {

    List<AnswerDto> create(List<AnswerDto> answerDto);
}
