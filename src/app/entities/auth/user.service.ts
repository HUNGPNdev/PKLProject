import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserInfo } from './user-infor';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private Url = 'http://localhost:8080/api/test/';
  private baseUrl = 'http://localhost:8080/admin/user';
 
  constructor(private http: HttpClient) { }
 
  getUserBoard(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}`);
  }
  
  getUserById(id: number): Observable<UserInfo> {
    return this.http.get<UserInfo>(`${this.baseUrl}/${id}`);
  }
 
  getAdminBoard(): Observable<string> {
    return this.http.get(`${this.Url}admin`, { responseType: 'text' });
  }

  updateUser(id: number,user: UserInfo): Observable<UserInfo> {
    return this.http.put<UserInfo>(`${this.baseUrl}/${id}`, user);
  }

  deleteUserById(id: number): Observable<Object> {
    return this.http.delete<Object>(`${this.baseUrl}/${id}`);
  }
}
