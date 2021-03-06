package com.adekah.mypetproject.service.impl;

import com.adekah.mypetproject.dto.AnswerDto;
import com.adekah.mypetproject.dto.QuestionDto;
import com.adekah.mypetproject.entity.Answer;
import com.adekah.mypetproject.entity.Question;
import com.adekah.mypetproject.entity.Quiz;
import com.adekah.mypetproject.repository.AnswerRepository;
import com.adekah.mypetproject.repository.QuestionRepository;
import com.adekah.mypetproject.repository.QuizRepository;
import com.adekah.mypetproject.service.QuestionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final ModelMapper modelMapper;
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;
    private final AnswerServiceImpl answerServiceImpl;

    public QuestionServiceImpl(ModelMapper modelMapper, QuestionRepository questionRepository, QuizRepository quizRepository, AnswerRepository answerRepository, AnswerServiceImpl answerServiceImpl) {
        this.modelMapper = modelMapper;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.answerRepository = answerRepository;
        this.answerServiceImpl = answerServiceImpl;
    }

    Date currentUtilDate = new Date();


    @Override
    public List<QuestionDto> create(List<QuestionDto> question) {
        for (QuestionDto questionDto : question) {
            Question q = modelMapper.map(question, Question.class);
            q.setCreatedAt(currentUtilDate);
            Quiz quiz = quizRepository.getOne(questionDto.getQuizId());
            q.setQuestionText(questionDto.getQuestionText());
            q.setQuestionQuiz(quiz);
            q.setIsActive(true);
            q = questionRepository.save(q);
            for (AnswerDto answerDto : questionDto.getQuestionAnswers()) {
                AnswerDto answers = modelMapper.map(answerDto, AnswerDto.class);
                answers.setQuestionId(q.getId());
            }
            answerServiceImpl.create(questionDto.getQuestionAnswers());
            questionDto.setId(q.getId());

        }
        return question;
    }

    @Override
    public QuestionDto getById(Long questionId) {
        Question question = questionRepository.getOne(questionId);
        return modelMapper.map(question, QuestionDto.class);
    }

    public List<QuestionDto> getByQuizId(Long id) {

        return Arrays.asList(modelMapper.map(questionRepository.findByQuestionQuizId(id), QuestionDto[].class));
    }

    @Override
    public Boolean delete(Long questionId) {
        questionRepository.deleteById(questionId);
        return true;
    }


}
