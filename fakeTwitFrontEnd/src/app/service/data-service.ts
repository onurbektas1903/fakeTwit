import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams, HttpResponse} from '@angular/common/http';

@Injectable()
export class DataService {
  apiUrl: string;

  constructor(private http: HttpClient) {
    // this.apiUrl = environment.API_URL; şeklinde prod / local ayrımı yapılabilirdi. Aşağıdada localhost yerine api url verilebilir.
  }

  public getMessages() {

    let options = this.createRequestOptions();
    var headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    let params = new HttpParams().set('block', 'true');

    return this.http.get('http://localhost:8084' + '/listMessages', {headers: options, params: params});
  }

public sendMessage(obj) {
  let options = this.createRequestOptions();
  var headers = new HttpHeaders();
  headers.set('Content-Type', 'application/json');
  return this.http.post('http://localhost:8084' + '/appendMessage', obj, {headers: options});
}

  private createRequestOptions() {
    let headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json');
    return headers;
  }
}
