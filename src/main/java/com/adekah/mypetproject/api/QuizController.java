package com.adekah.mypetproject.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Api(description="Quiz Apis")
@RequestMapping("/api/quiz")
public class QuizController {
}
