package com.adekah.mypetproject.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

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
