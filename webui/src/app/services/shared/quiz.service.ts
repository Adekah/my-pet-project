import {Injectable} from "@angular/core";
import {ApiService} from "../api.service";
import {Observable} from "rxjs";
import {map} from "rxjs/operators";
import {id} from "@swimlane/ngx-datatable/release/utils";

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private QUIZ_PATH = "/quiz/create";
  activeUser = {
    id: id()
  };
  constructor(private apiService: ApiService) {
  }

  createQuiz(quiz): Observable<any> {
    this.activeUser = JSON.parse(localStorage.getItem('currentUser'));
    quiz["ownerId"] = this.activeUser.id;
    return this.apiService.post(this.QUIZ_PATH, quiz).pipe(map(
      res => {
        if (res) {
          return true;
        } else {
          console.log(res);
          return false;
        }
      }
    ));
  }
}
