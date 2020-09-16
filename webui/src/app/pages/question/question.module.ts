import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {QuestionComponent} from './question.component';
import {TranslateModule} from "@ngx-translate/core";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [QuestionComponent],
  exports: [QuestionComponent],
  imports: [
    CommonModule,
    TranslateModule,
    ReactiveFormsModule
  ]
})
export class QuestionModule {
}
