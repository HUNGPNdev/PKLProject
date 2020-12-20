import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Banner } from './banner';

@Injectable({
  providedIn: 'root'
})
export class BannerService {

  private baseUrl = "http://localhost:8080/admin/banner";

  constructor(private httpClient: HttpClient) { }


  getAllBanner(): Observable<Banner[]> {
    return this.httpClient.get<Banner[]>(`${this.baseUrl}`);
  }

  createBanner(file: any): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, file);
  }

  getById(id: number): Observable<Banner> {
    return this.httpClient.get<Banner>(`${this.baseUrl}/${id}`);
  }

  updateById(id: number, file: any): Observable<Object> {
    return this.httpClient.put<Object>(`${this.baseUrl}/${id}`, file);
  }

  deleteById(id:number): Observable<Object>{
    return this.httpClient.delete<Object>(`${this.baseUrl}/${id}`);
  }

}
