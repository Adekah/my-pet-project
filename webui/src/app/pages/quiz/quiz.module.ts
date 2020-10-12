import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {QuizComponent} from './quiz.component';
import {QuizRoutingModule} from './quiz.routing.module';
import {TranslateModule} from "@ngx-translate/core";
import {ReactiveFormsModule} from "@angular/forms";
import {CreateQuizComponent} from './create-quiz/create-quiz.component';
import {QuestionModule} from "../question/question.module";

@NgModule({
  declarations: [QuizComponent, CreateQuizComponent],
  exports: [
    QuizComponent,
    CreateQuizComponent
  ],
  imports: [
    CommonModule,
    QuizRoutingModule,
    TranslateModule,
    ReactiveFormsModule,
    QuestionModule
  ]
})
export class QuizModule {
}
