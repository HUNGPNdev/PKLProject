import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtResponse } from './jwt-response';
import { SigupInfo } from './sigup-info';
import { User } from './user';
import { UserInfo } from './user-infor';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
const USER_INFO = '';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public user: UserInfo;

  private Url = 'http://localhost:8080/api/auth/';
  private userUrl = 'http://localhost:8080/user';

 
  constructor(private http: HttpClient) {
  }
 
  attemptAuth(user: User): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(`${this.Url}signin`, user, httpOptions);
  }

  getUserByName(name: string): Observable<UserInfo> {
    return this.http.get<UserInfo>(`${this.userUrl}/${name}`);
  }

  saveUserInfo(user: UserInfo) {
    window.sessionStorage.removeItem(USER_INFO);
    window.sessionStorage.setItem(USER_INFO, JSON.stringify(user));
  }


  getUserInfo(): any {
    this.user = JSON.parse(sessionStorage.getItem(USER_INFO)  || "{}" );
    return this.user;
  }

  signOut() {
    window.sessionStorage.clear();
  }
 
  signUp(info: SigupInfo): Observable<string> {
    return this.http.post<string>(`${this.Url}signup`, info, httpOptions);
  }

  updateUser(user: SigupInfo): Observable<UserInfo> {
    return this.http.put<UserInfo>(`${this.userUrl}/`, user);
  }
}
