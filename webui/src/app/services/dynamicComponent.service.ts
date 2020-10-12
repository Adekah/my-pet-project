import {
  ComponentFactoryResolver,
  Injectable,
  Inject,
  ReflectiveInjector
} from '@angular/core'

import {CreateMultipleChoiceQuestionComponent} from "../pages/question/create-multiple-choice-question/create-multiple-choice-question.component";
import {Injector} from "@angular/core/src/di/injector";

@Injectable()
export class DynamicComponentService {
  rootViewContainer: any;

  constructor(private factoryResolver: ComponentFactoryResolver) {
  }

  public setRootViewContainerRef(viewContainerRef) {
    this.rootViewContainer = viewContainerRef
  }

  public addDynamicComponent() {
    const factory = this.factoryResolver.resolveComponentFactory(CreateMultipleChoiceQuestionComponent)
    const component = factory.create(this.rootViewContainer.Injector)
    this.rootViewContainer.insert(component.hostView)
  }
}
