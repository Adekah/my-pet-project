import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {QuestionComponent} from './question.component';
import {TranslateModule} from "@ngx-translate/core";
import {ReactiveFormsModule} from "@angular/forms";
import { CreateMultipleChoiceQuestionComponent } from './create-multiple-choice-question/create-multiple-choice-question.component';

@NgModule({
  declarations: [QuestionComponent, CreateMultipleChoiceQuestionComponent],
    exports: [QuestionComponent, CreateMultipleChoiceQuestionComponent],
  imports: [
    CommonModule,
    TranslateModule,
    ReactiveFormsModule
  ]
})
export class QuestionModule {
}
