package com.adekah.mypetproject.api;

import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.service.impl.QuizServiceImpl;
import com.adekah.mypetproject.util.ApiPaths;
import com.adekah.mypetproject.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
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
    @ApiOperation(value = "Create Quiz Operation", response = QuizDto.class)
    public ResponseEntity<QuizDto> createQuiz(@Valid @RequestBody QuizDto quiz) {
        return ResponseEntity.ok(quizServiceImpl.create(quiz));
    }


    @ApiOperation(value = "Delete Quiz Operation", response = boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(quizServiceImpl.delete(id));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = QuizDto.class)
    public ResponseEntity<QuizDto> getById(@PathVariable(value = "id", required = true) Long id) {
        QuizDto quizDto = quizServiceImpl.getById(id);
        return ResponseEntity.ok(quizDto);
    }

//    @GetMapping("/detail/{id}")
//    @ApiOperation(value = "Get By Id With Details", response = QuizDto.class)
//    public ResponseEntity<QuizDto> getByIdWithDetails(@PathVariable(value = "id", required = true) Long id) {
//        QuizDto detailDto = quizServiceImpl.getByIdWithDetails(id);
//        return ResponseEntity.ok(detailDto);
//    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = QuizDto.class)
    public ResponseEntity<TPage<QuizDto>> getAllByPagination(Pageable pageable) {
        TPage<QuizDto> data = quizServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

}
