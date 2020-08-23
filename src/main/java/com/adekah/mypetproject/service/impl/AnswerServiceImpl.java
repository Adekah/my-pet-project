package com.adekah.mypetproject.service.impl;

import com.adekah.mypetproject.dto.AnswerDto;
import com.adekah.mypetproject.entity.Answer;
import com.adekah.mypetproject.repository.AnswerRepository;
import com.adekah.mypetproject.service.AnswerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final ModelMapper modelMapper;
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(ModelMapper modelMapper, AnswerRepository answerRepository) {
        this.modelMapper = modelMapper;
        this.answerRepository = answerRepository;
    }

    Date currentUtilDate = new Date();

    @Override
    public void create(List<AnswerDto> answerDtoList) {

        for(AnswerDto answerDto:answerDtoList){
            Answer answer = modelMapper.map(answerDtoList, Answer.class);
            answer.setCreatedAt(currentUtilDate);
            answer.setIsActive(true);
            answer = answerRepository.save(answer);
        }
    }
}
