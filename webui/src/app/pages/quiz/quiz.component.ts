import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {BsModalRef, BsModalService, ModalDirective} from "ngx-bootstrap";
import {FormGroup} from "@angular/forms";

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss']
})
export class QuizComponent implements OnInit {

  // modalRef: BsModalRef;

  quizForm: FormGroup;
  @ViewChild('createQuiz') createQuizModal: ModalDirective;

  constructor(
    private modalService: BsModalService
  ) {

  }

  ngOnInit() {
  }

  // openModal(template: TemplateRef<any>) {
  //   this.modalRef = this.modalService.show(template);
  // }

  get f() {
    return this.quizForm.controls
  }

  saveQuiz() {

  }

  show():void {
    this.createQuizModal.show();
  }


  closeAndResetModal() {
    this.createQuizModal.hide();
  }


}
