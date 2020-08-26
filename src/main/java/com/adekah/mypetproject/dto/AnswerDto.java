package com.adekah.mypetproject.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Answer Data Transfer Object")
public class AnswerDto {

    @ApiModelProperty(required = true, value = "ID")
    private Long id;

    @ApiModelProperty(required = true, value = "AnswerText")
    private String answerText;

    @ApiModelProperty(required = true, value = "is True Answer")
    private Boolean isTrueAnswer;

    @NotNull
    @ApiModelProperty(required = true, value = "OwnerId")
    private Long questionId;
}
