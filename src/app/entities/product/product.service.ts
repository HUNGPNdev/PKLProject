import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Order } from './order';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/admin/product";
  private order = "http://localhost:8080/admin/order";

  constructor(private httpClient: HttpClient) { }

  createProduct(file: any): Observable<Object> {
    return this.httpClient.post(`${this.baseUrl}`, file);
  }

  getAllProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}`);
  } 

  getProById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.baseUrl}/${id}`);
  }

  updateProById(file: any): Observable<Object> {
    return this.httpClient.put<Object>(`${this.baseUrl}`, file);
  }

  deleteById(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`);
  }

  getListOrder(): Observable<Order[]> {
    return this.httpClient.get<Order[]>(`${this.order}`);
  }

  deleteOrderById(id: number): Observable<Object> {
    return this.httpClient.delete<Object>(`${this.order}/${id}`);
  }
}
