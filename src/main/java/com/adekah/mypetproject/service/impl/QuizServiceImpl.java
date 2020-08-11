package com.adekah.mypetproject.service.impl;

import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.entity.Quiz;
import com.adekah.mypetproject.repository.QuizRepository;
import com.adekah.mypetproject.service.QuizService;
import com.adekah.mypetproject.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;

@Service
public class QuizServiceImpl  implements QuizService {

    private final QuizRepository quizRepository;
    private final ModelMapper modelMapper;

    public QuizServiceImpl(QuizRepository quizRepository, ModelMapper modelMapper) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public QuizDto save(QuizDto quiz) {
        Quiz q = modelMapper.map(quiz, Quiz.class);
        q = quizRepository.save(q);
        quiz.setId(q.getId());
        return quiz;
    }

    @Override
    public QuizDto getById(Long id) {
        return null;
    }

    @Override
    public TPage<QuizDto> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public QuizDto getByName(String name) {
        return null;
    }
}
