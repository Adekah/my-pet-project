import {RouterModule, Routes} from '@angular/router';
import {QuizComponent} from './quiz.component';
import {NgModule} from '@angular/core';
import {CreateQuizComponent} from "./create-quiz/create-quiz.component";


const routes: Routes = [
  {
    path: '',
    component: QuizComponent
  },
  {
    path: 'create',
    component: CreateQuizComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class QuizRoutingModule {
}
