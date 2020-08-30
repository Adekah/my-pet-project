import {Component, OnInit, ViewChild} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {ModalDirective} from "ngx-bootstrap";

@Component({
  selector: 'app-create-quiz-modal',
  templateUrl: './create-quiz-modal.component.html',
  styleUrls: ['./create-quiz-modal.component.scss']
})
export class CreateQuizModalComponent implements OnInit {

  quizForm: FormGroup;
  @ViewChild('createQuiz') createQuizModal: ModalDirective;


  constructor() { }

  ngOnInit() {
  }
  get f() {
    return this.quizForm.controls
  }

  saveQuiz() {

  }

  show():void {
    this.createQuizModal.show();
  }

  openModal() {
    this.createQuizModal.show();
  }



  closeAndResetModal() {
    this.createQuizModal.hide();
  }

}
