import {Component, TemplateRef, ViewChild} from '@angular/core';
import {NavigationEnd, Router} from '@angular/router';
import {BsModalRef, BsModalService} from "ngx-bootstrap";
import {getLViewChild} from "@angular/core/src/render3/node_manipulation";
import {QuizComponent} from "../../pages/quiz/quiz.component";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent {
  isActive: boolean = false;
  showMenu: string = '';
  pushRightClass: string = 'push-right';
  collapseClass: string = 'collapsed';
  // modalRef: BsModalRef;

  @ViewChild('createQuiz') createQuizModal: QuizComponent;





  constructor(public router: Router, private modalService: BsModalService) {
    this.router.events.subscribe(val => {
      if (
        val instanceof NavigationEnd &&
        window.innerWidth <= 992 &&
        this.isToggled()
      ) {
        this.toggleSidebar();
      }
    });
    this.showMenu = 'dashboard';
  }

  // createCity(): void {
  //   this.publicationService.getAllPublicationDetails(0, 10)
  //     .subscribe((result: PublicationDetails) => {
  //       this.createPublicationModal.show(result);
  //     });
  // }


  openModal(template: TemplateRef<any>) {
        this.createQuizModal.show();
  }




  eventCalled() {
    this.isActive = !this.isActive;
  }

  addExpandClass(element: any) {
    if (element === this.showMenu) {
      this.showMenu = '0';
    } else {
      this.showMenu = element;
    }
  }




  isToggled(): boolean {
    const dom: Element = document.querySelector('aside');
    return (dom) ? dom.classList.contains(this.collapseClass) : false;
  }

  toggleSidebar() {
    const dom: any = document.querySelector('aside');
    (dom) ? dom.classList.toggle(this.collapseClass) : '';
    const cdom: any = document.querySelector('#main-container');
    (cdom) ? cdom.classList.toggle(this.collapseClass) : '';
  }

}
