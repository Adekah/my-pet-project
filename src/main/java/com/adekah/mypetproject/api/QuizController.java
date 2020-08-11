package com.adekah.mypetproject.api;

import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.service.impl.QuizServiceImpl;
import com.adekah.mypetproject.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(description = "Quiz Apis")
@RequestMapping(ApiPaths.QuizController.CTRL)
public class QuizController {

    private final QuizServiceImpl quizServiceImpl;
    private final ModelMapper modelMapper;

    public QuizController(QuizServiceImpl quizServiceImpl, ModelMapper modelMapper) {
        this.quizServiceImpl = quizServiceImpl;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = QuizDto.class)
    public ResponseEntity<QuizDto> createQuiz(@Valid @RequestBody QuizDto quiz) {
        return ResponseEntity.ok(quizServiceImpl.save(quiz));
    }
}
