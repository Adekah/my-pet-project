import {Component, ComponentFactoryResolver, OnInit, ViewContainerRef} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {QuizService} from "../../../services/shared/quiz.service";
import {ToastrService} from "ngx-toastr";
import {DynamicComponentService} from "../../../services/dynamicComponent.service";

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
              private toastr: ToastrService,
              public dynamicComponent: DynamicComponentService,
              public viewContainerRef: ViewContainerRef) {
  }

  ngOnInit() {
    this.quizForm = this.formBuilder.group({
      'explanation': [null, [Validators.required, Validators.minLength(2), Validators.maxLength(500)]],
      'name': [null, [Validators.required, Validators.minLength(4)]]
    })
  }

  add() {
    this.dynamicComponent.setRootViewContainerRef(this.viewContainerRef);
    this.dynamicComponent.addDynamicComponent()
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
          if (response === true) {
            this.resetForm();
          } else {
            this.showToastr(false);
          }

        }
      )
    }
  }

  resetForm() {
    this.showToastr(true);
    this.quizForm.reset();
    this.submitted = false;
  }

  showToastr(isSuccess) {
    if (isSuccess == true) {
      this.toastr.success('Quiz Created', 'Success');
    } else {
      this.toastr.error('Error', 'Error');
    }

  }

}


