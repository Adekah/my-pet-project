import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {QuestionService} from "../../../services/shared/question.service";
import {ToasterService} from "ngx-toaster/src/lib";

@Component({
  selector: 'app-create-multiple-choice-question',
  templateUrl: './create-multiple-choice-question.component.html',
  styleUrls: ['./create-multiple-choice-question.component.scss']
})
export class CreateMultipleChoiceQuestionComponent implements OnInit {
  questionForm: FormGroup;
  submitted = false;

  constructor(private questionService: QuestionService,
              private formBuilder: FormBuilder,
              private toastr: ToasterService) {
  }

  ngOnInit() {
  }

  get f() {
    return this.questionForm.controls
  }

  saveQuestion() {
    this.submitted = true;
    if (!this.questionForm.valid) {
      return;
    } else {
      this.questionService.createQuestion(this.questionForm.value).subscribe(
        response => {

        }
      )
    }

  }

}
