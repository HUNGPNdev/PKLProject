import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtResponse } from './jwt-response';
import { LoginInfo } from './login-info';
import { SignupInfo } from './signup-info';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private Url = 'http://localhost:8080/api/auth/';
 
  constructor(private http: HttpClient) {
  }
 
  attemptAuth(credentials: LoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(`${this.Url}signin`, credentials, httpOptions);
  }
 
  signUp(info: SignupInfo): Observable<string> {
    return this.http.post<string>(`${this.Url}signup`, info, httpOptions);
  }
}
