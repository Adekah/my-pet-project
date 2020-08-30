import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {QuizService} from "../../../services/shared/quiz.service";

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss']
})
export class CreateQuizComponent implements OnInit {
  quizForm: FormGroup;

  constructor(private quizService: QuizService) {
  }

  ngOnInit() {
  }

  saveQuiz() {
    if (!this.quizForm.valid)
      return;
    this.quizService.createQuiz(this.quizForm.value)
  }
}
