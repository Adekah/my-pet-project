package com.adekah.mypetproject.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    @ApiModelProperty(required = true, value = "ID")
    private Long id;

    @ApiModelProperty(value = "Explanation")
    private String explanation;

    @ApiModelProperty(required = true,value = "Name")
    private String name;

    @ApiModelProperty(required = true,value = "Number Of Questions")
    private byte numberOfQuestions;

    @NotNull
    @ApiModelProperty(required = true,value = "OwnerId")
    private Long ownerId;
    @ApiModelProperty(required = true,value = "Quiz Owner Id")
    private UserDto owner;
}
