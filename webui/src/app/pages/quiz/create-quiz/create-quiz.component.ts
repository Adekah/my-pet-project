import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuizService} from "../../../services/shared/quiz.service";

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss']
})
export class CreateQuizComponent implements OnInit {
  quizForm: FormGroup;

  constructor(private quizService: QuizService,
              private formBuilder: FormBuilder,) {
  }

  ngOnInit() {
    this.quizForm = this.formBuilder.group({
      'explanation': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(500)]],
      'name': [null, [Validators.required, Validators.minLength(4)]]
    })
  }

  saveQuiz() {
    if (!this.quizForm.valid) {
      return;
    } else {
      this.quizService.createQuiz(this.quizForm.value).subscribe()
    }
  }

}


