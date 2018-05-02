import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {User} from '../entity/user';

@Injectable()
export class AuthenticationService {
  public token: string;

  constructor(private http: HttpClient) {
    // set token if saved in local storage
    debugger;


    // var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    // this.token = currentUser && currentUser.token;
  }
  public login(obj:User) {
    let options = this.createRequestOptions();
    var headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return this.http.post('http://localhost:8084' + '/login', obj, {headers: options});
  }

  logout(){
    localStorage.removeItem("currentUser");
    localStorage.removeItem("token");
    this.token = null;
  }
  private createRequestOptions() {
    let headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return headers;
  }

}
