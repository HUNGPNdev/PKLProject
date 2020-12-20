import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cart } from './cart';
import { Order } from './order';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = "http://localhost:8080/user/product";
  private Url = "http://localhost:8080/user";

  constructor(private httpClient: HttpClient) { }

  getAllProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}`);
  }

  getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.baseUrl}/${id}`);
  }

  addCart(cart: Cart): Observable<Object> {
    return this.httpClient.post(`${this.Url}/cart`, cart);
  }

  getProductByUserId(id: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.Url}/cart-list/${id}`);
  }

  updateCart(id: number, form: any): Observable<Object> {
    return this.httpClient.put<Object>(`${this.Url}/cart/${id}`, form);
  }

  deleteCart(user_id: number, pro_id: number): Observable<Object> {
    return this.httpClient.delete<Object>(`${this.Url}/cart-delete/${user_id}/${pro_id}`);
  }

  getOrderByUserId(id: number): Observable<Order[]> {
    return this.httpClient.get<Order[]>(`${this.Url}/cart-list/${id}`);
  }

  orderPro(id: number, order: Order[]): Observable<Order[]> {
    return this.httpClient.post<Order[]>(`${this.Url}/order/${id}`, order);
  }

  getListOrder(id: number): Observable<Order[]> {
    return this.httpClient.get<Order[]>(`${this.Url}/order/${id}`);
  }

}
