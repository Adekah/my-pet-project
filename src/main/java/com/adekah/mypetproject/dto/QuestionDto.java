package com.adekah.mypetproject.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Question Data Transfer Object")
public class QuestionDto {

    @ApiModelProperty(required = true, value = "ID")
    private Long id;

    @ApiModelProperty(required = true, value = "QuestionText")
    private String questionText;

    @ApiModelProperty(required = true, value = "QuestionImage")
    private String questionImage;

    @NotNull
    @ApiModelProperty(required = true, value = "QuizId")
    private Long quizId;

    @ApiModelProperty(required = true, value = "Question Quiz Id")
    private QuizDto quiz;

    @ApiModelProperty(required = true, value = "Quiz Answers")
    private List<AnswerDto> questionAnswers;

}
