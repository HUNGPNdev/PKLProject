import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from './category';
import { Product } from './product/product';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = "http://localhost:8080/user/catagory";

  constructor(private httpClient: HttpClient) { }

  listCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(`${this.baseUrl}`);
  }

  getProByCateId(id: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}/${id}`);
  }

  
}
