import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizComponent } from './quiz.component';
import {QuizRoutingModule} from './quiz.routing.module';
import {TranslateModule} from "@ngx-translate/core";
import {ReactiveFormsModule} from "@angular/forms";
import { CreateQuizModalComponent } from './create-quiz-modal/create-quiz-modal.component';

@NgModule({
  declarations: [QuizComponent, CreateQuizModalComponent],
  exports: [
    QuizComponent,
    CreateQuizModalComponent
  ],
  imports: [
    CommonModule,
    QuizRoutingModule,
    TranslateModule,
    ReactiveFormsModule
  ]
})
export class QuizModule { }
