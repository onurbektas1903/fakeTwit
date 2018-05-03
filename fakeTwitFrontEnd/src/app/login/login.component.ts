import { Component, OnInit } from '@angular/core';
import {User} from '../entity/user';
import {AuthenticationService} from '../service/auth-service';
import {Router} from '@angular/router';
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

  isDisabled(){
    return (!this.user.password || this.user.password === "" || !this.user.userName || this.user.userName === "");
  }

}
