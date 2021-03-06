import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {AuthenticationService} from './security/authentication.service';
import {AuthGuard} from './security/auth.guard';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {JwtInterceptor} from './security/jwt.interceptor';
import {ErrorInterceptor} from './security/authentication.interceptor';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app.routing.module';
import {NotfoundComponent} from './shared/notfound/notfound.component';
import {AppLayoutComponent} from './_layout/app-layout/app-layout.component';
import {HeaderComponent} from './_layout/header/header.component';
import {FooterComponent} from './_layout/footer/footer.component';
import {SidebarComponent} from './_layout/sidebar/sidebar.component';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {BsDropdownModule, ModalModule} from "ngx-bootstrap";
import {ApiService} from "./services/api.service";
import {QuizService} from "./services/shared/quiz.service";
import {ToastrModule} from "ngx-toastr";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {DynamicComponentService} from "./services/dynamicComponent.service";

export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}

@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    LoginComponent,
    RegisterComponent,
    NotfoundComponent,
    AppLayoutComponent,
    HeaderComponent,
    FooterComponent,
    SidebarComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({timeOut: 3000, progressAnimation: 'decreasing', progressBar: true}),
    FormsModule,
    ReactiveFormsModule,
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
    }),
  ],
  providers: [ApiService,
    QuizService,
    AuthenticationService,
    AuthGuard,
    DynamicComponentService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},],
  bootstrap: [AppComponent]
})
export class AppModule {
}
