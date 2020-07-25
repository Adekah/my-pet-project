import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizComponent } from './quiz.component';
import {QuizRoutingModule} from './quiz.routing.module';

@NgModule({
  declarations: [QuizComponent],
  imports: [
    CommonModule,
    QuizRoutingModule
  ]
})
export class QuizModule { }
