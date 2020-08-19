package com.adekah.mypetproject.api;

import com.adekah.mypetproject.dto.QuestionDto;
import com.adekah.mypetproject.dto.QuizDto;
import com.adekah.mypetproject.dto.UserDto;
import com.adekah.mypetproject.service.impl.QuestionServiceImpl;
import com.adekah.mypetproject.service.impl.QuizServiceImpl;
import com.adekah.mypetproject.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(description = "Question Apis")
@RequestMapping(ApiPaths.QuestionController.CTRL)
public class QuestionController {

    private final QuestionServiceImpl questionServiceImpl;

    public QuestionController(QuestionServiceImpl questionServiceImpl) {
        this.questionServiceImpl = questionServiceImpl;
    }

    @ApiOperation(value = "Create Question Operation", response = QuestionDto.class)
    @RequestMapping(method = RequestMethod.POST,value="/create")
    public ResponseEntity<QuestionDto> createQuestion(@Valid @RequestBody QuestionDto question) {
        return ResponseEntity.ok(questionServiceImpl.create(question));
    }

    @ApiOperation(value = "Delete Question Operation", response = boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(questionServiceImpl.delete(id));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = QuestionDto.class)
    public ResponseEntity<QuestionDto> getById(@PathVariable(value = "id", required = true) Long id) {
        QuestionDto questionDto = questionServiceImpl.getById(id);
        return ResponseEntity.ok(questionDto);
    }

    @GetMapping("/quiz/{id}")
    @ApiOperation(value = "Get All By Operation", response = QuestionDto.class)
    public ResponseEntity<List<QuestionDto>> getByQuizId(Long quizId) {
        List<QuestionDto> data = questionServiceImpl.getByQuizId(quizId);
        return ResponseEntity.ok(data);
    }
}
