package com.adekah.mypetproject.service;

import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.util.TPage;
import org.springframework.data.domain.Pageable;

public interface QuizService {

    QuizDto create(QuizDto quiz);

    QuizDto getById(Long id);

    Boolean delete (Long id);

    TPage<QuizDto> getAllPageable(Pageable pageable);

    QuizDto getByName(String name);

}
