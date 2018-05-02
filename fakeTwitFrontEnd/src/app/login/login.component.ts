import { Component, OnInit } from '@angular/core';
import {User} from '../entity/user';
import {AuthenticationService} from '../service/auth-service';
import {Router} from '@angular/router';
import {errorHandler} from '@angular/platform-browser/src/browser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:User;
  constructor(    private loginService:AuthenticationService,
                  private router: Router
                  ) { }

  ngOnInit() {
    this.user = new User();
  }
  login(){
    this.loginService.login(this.user).subscribe((e:User)=>{
      localStorage.setItem("currentUser",e.userName);
      this.router.navigate(['/home']);
    },(error => {
      debugger;
     alert(error.error.message);
    }));
  }
}
