import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private QUIZ_PATH = "/quiz/create";

  constructor(private apiService: ApiService) {
  }


  createQuiz(quiz): Observable<any> {
    return this.apiService.post(this.QUIZ_PATH, quiz).pipe(map(
      res => {
        if (res) {
          return res;
        } else {
          console.log(res);
          return {};
        }
      }
    ));
  }
}
