import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserMessageComponent} from './user-message/user-message.component';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './service/auth-guard.service';
import {HomeComponent} from './home/home.component';

const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate:[AuthGuard]
  },
  { path: '',
    component: LoginComponent,
    canActivate:[AuthGuard] },

  { path: 'userMessage',
    component: UserMessageComponent,
    canActivate:[AuthGuard] },


  { path: '**', redirectTo: '/not-found' }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
