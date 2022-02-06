import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/app/model/user.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public endpoint = 'http://localhost:8080/api/v1/employer';
  public loggedIn: boolean =false;


  constructor(private http:HttpClient) { }

  public login(user: User){

    let response = this.http.post<User>(this.endpoint+'/login', user);
    // if(response.pipe)
    // return this.loggedIn;
    return response;
  }
}
