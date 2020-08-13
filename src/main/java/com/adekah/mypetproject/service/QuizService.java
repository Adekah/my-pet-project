package com.adekah.mypetproject.service;

import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.util.TPage;

import java.awt.print.Pageable;

public interface QuizService {

    QuizDto create(QuizDto quiz);

    QuizDto getById(Long id);

    TPage<QuizDto> getAllPageable(Pageable pageable);

    QuizDto getByName(String name);

}
