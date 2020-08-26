package com.adekah.mypetproject.service.impl;

import com.adekah.mypetproject.dto.AnswerDto;
import com.adekah.mypetproject.entity.Answer;
import com.adekah.mypetproject.entity.Question;
import com.adekah.mypetproject.repository.AnswerRepository;
import com.adekah.mypetproject.repository.QuestionRepository;
import com.adekah.mypetproject.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(ModelMapper modelMapper, AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.modelMapper = modelMapper;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    Date currentUtilDate = new Date();

    @Override
    public void create(List<AnswerDto> answerDtoList) {

        for (AnswerDto answerDto : answerDtoList) {
            Answer answer = modelMapper.map(answerDto, Answer.class);
            answer.setCreatedAt(currentUtilDate);
            answer.setIsActive(true);
            Question question = questionRepository.getOne(answerDto.getQuestionId());
            answer.setQuestion(question);
            answerRepository.save(answer);
        }
    }
}
