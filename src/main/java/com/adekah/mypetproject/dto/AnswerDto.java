package com.adekah.mypetproject.dto;

import io.swagger.annotations.ApiModelProperty;

public class AnswerDto {

    @ApiModelProperty(required = true, value = "ID")
    private Long id;

    @ApiModelProperty(required = true, value = "AnswerText")
    private String answerText;
}
