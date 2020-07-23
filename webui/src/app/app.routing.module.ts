import {RouterModule, Routes} from "@angular/router";
import {AuthGuard} from "./security/auth.guard";
import {NgModule} from "@angular/core";
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {NotfoundComponent} from "./shared/notfound/notfound.component";

const routes: Routes = [
  // {
  //   path: '',  canActivate: [AuthGuard],
  //   children: [
  //     {path: '', pathMatch: 'full', redirectTo: 'dashboard'}
  //   ]
  // },
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: '**', component: NotfoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}