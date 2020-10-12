import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuestionService} from "../../../services/shared/question.service";

@Component({
  selector: 'app-create-multiple-choice-question',
  templateUrl: './create-multiple-choice-question.component.html',
  styleUrls: ['./create-multiple-choice-question.component.scss']
})
export class CreateMultipleChoiceQuestionComponent implements OnInit {
  questionForm: FormGroup;
  submitted = false;

  constructor(private questionService: QuestionService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.questionForm = this.formBuilder.group({
      'question': [null, [Validators.required, Validators.minLength(8), Validators.maxLength(500)]],
      'optionOne': [null, [Validators.required, Validators.minLength(2)]],
      'optionTwo': [null, [Validators.required, Validators.minLength(2)]]
    })
  }

  get f() {
    return this.questionForm.controls
  }

  saveQuestion() {
    this.submitted = true;
    if (!this.questionForm.valid) {
      return;
    } else {

      const formValue = this.questionForm.value as FormArray;
      console.log(formValue);
      console.log("formValue");
      formValue.push(this.formBuilder.group({
        question: '',
        optionOne: '',
        optionTwo: ''
      }));
      this.questionService.createQuestion(this.questionForm.value as FormArray).subscribe(
        response => {

        }
      )
    }

  }

}
