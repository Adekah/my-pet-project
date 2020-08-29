import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ConfirmationComponent} from './confirmation/confirmation.component';
import {ModalModule} from 'ngx-bootstrap';
import {TranslateModule} from "@ngx-translate/core";

@NgModule({

  entryComponents: [ConfirmationComponent],
  declarations: [ConfirmationComponent],
  imports: [
    CommonModule, ModalModule.forRoot()
  ],
  exports: [ModalModule, TranslateModule]
})
export class SharedModule {
}
