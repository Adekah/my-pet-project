import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuizService} from "../../../services/shared/quiz.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-create-quiz',
  templateUrl: './create-quiz.component.html',
  styleUrls: ['./create-quiz.component.scss']
})
export class CreateQuizComponent implements OnInit {
  quizForm: FormGroup;
  submitted = false;

  constructor(private quizService: QuizService,
              private formBuilder: FormBuilder,
              private toastr: ToastrService) {
  }

  ngOnInit() {
    this.quizForm = this.formBuilder.group({
      'explanation': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(500)]],
      'name': [null, [Validators.required, Validators.minLength(4)]]
    })
  }

  get f() {
    return this.quizForm.controls
  }

  saveQuiz() {
    this.submitted = true;
    if (!this.quizForm.valid) {
      return;
    } else {
      this.quizService.createQuiz(this.quizForm.value).subscribe(
        response => {
          this.resetForm();
        }
      )
    }
  }

  resetForm() {
    this.showToastr()
    this.quizForm.reset();
    this.submitted = false;
  }

  showToastr() {
    this.toastr.show('I am a standard toast');
  }

}


