package com.adekah.mypetproject.service.impl;

import com.adekah.mypetproject.dto.QuestionDto;
import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.entity.Quiz;
import com.adekah.mypetproject.entity.User;
import com.adekah.mypetproject.repository.QuizRepository;
import com.adekah.mypetproject.repository.UserRepository;
import com.adekah.mypetproject.service.QuizService;
import com.adekah.mypetproject.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    Date currentUtilDate = new Date();

    public QuizServiceImpl(QuizRepository quizRepository,ModelMapper modelMapper, UserRepository userRepository) {
        this.quizRepository = quizRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @Override
    public QuizDto create(QuizDto quiz) {
        Quiz q = modelMapper.map(quiz, Quiz.class);
        q.setCreatedAt(currentUtilDate);
        User user = userRepository.getOne(quiz.getOwnerId());
        q.setOwner(user);
        q.setCreatedBy(user.getUsername());
        q.setIsActive(true);
        q = quizRepository.save(q);
        quiz.setId(q.getId());
        return quiz;
    }

    @Override
    public Boolean delete(Long quizId) {
        quizRepository.deleteById(quizId);
        return true;
    }

    @Override
    public TPage<QuizDto> getAllPageable(Pageable pageable) {
        Page<Quiz> data = quizRepository.findAll(pageable);
        TPage page = new TPage<QuizDto>();
        QuizDto[] dtos = modelMapper.map(data.getContent(), QuizDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;

    }

    @Override
    public QuizDto getById(Long id) {
        Quiz quiz = quizRepository.getOne(id);
        return modelMapper.map(quiz, QuizDto.class);
    }

//    public QuizDto getByIdWithDetails(Long id) {
//        Quiz quiz = quizRepository.getOne(id);
//        QuizDto quizDto = modelMapper.map(quiz, QuizDto.class);
//        List<QuestionDto> questionDtos = denemeeee.getByQuizId(quiz.getId());
//        quizDto.setQuizQuestions(questionDtos);
//        return quizDto;
//    }

    @Override
    public QuizDto getByName(String name) {
        return null;
    }
}
