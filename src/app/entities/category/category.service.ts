import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from './category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = "http://localhost:8080/admin/category";

  constructor(private httpClient: HttpClient) { }

  createCata(category:Category): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, category);
  }

  listCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(`${this.baseUrl}`);
  }

  getCateById(id: number): Observable<Category> {
    return this.httpClient.get<Category>(`${this.baseUrl}/${id}`);
  }

  updateById(id: number, cate: Category): Observable<Object> {
    return this.httpClient.put(`${this.baseUrl}/${id}`, cate);
  }

  deleteById(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

}
