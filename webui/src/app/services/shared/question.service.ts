import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})

export class QuestionService {
  private QUESTION_PATH = "/question/create";

  constructor(private apiService: ApiService) {
  }

  createQuestion(question): Observable<any> {
    return this.apiService.post(this.QUESTION_PATH, question).pipe(map(
      res => {
        if (res) {
          return true;
        } else {
          console.log(res);
          return false;
        }
      }
    ))
  }
}
