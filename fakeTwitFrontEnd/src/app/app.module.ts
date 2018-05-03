import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { UserMessageComponent } from './user-message/user-message.component';
import {DataService} from './service/data-service';
import { HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing-module';
import {AuthGuard} from './service/auth-guard.service';
import {FormsModule} from '@angular/forms';
import {AuthenticationService} from './service/auth-service';
import {DateTimeFormatPipe} from './util/date-format-pipe';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserMessageComponent,
    DateTimeFormatPipe,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [DataService,AuthGuard,AuthenticationService],
  bootstrap: [AppComponent]
})
export class AppModule { }
