import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateMultipleChoiceQuestionComponent } from './create-multiple-choice-question.component';

describe('CreateMultipleChoiceQuestionComponent', () => {
  let component: CreateMultipleChoiceQuestionComponent;
  let fixture: ComponentFixture<CreateMultipleChoiceQuestionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateMultipleChoiceQuestionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateMultipleChoiceQuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
