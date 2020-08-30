import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateQuizModalComponent } from './create-quiz-modal.component';

describe('CreateQuizModalComponent', () => {
  let component: CreateQuizModalComponent;
  let fixture: ComponentFixture<CreateQuizModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateQuizModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateQuizModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
