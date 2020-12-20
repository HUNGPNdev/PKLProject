import { Component, OnInit } from '@angular/core';
import { Category } from 'src/entities/category';
import { Title } from '@angular/platform-browser';
import { CategoryService } from 'src/entities/category.service';
import { HttpClient } from '@angular/common/http';
import { ProductService } from 'src/entities/product/product.service';
import { Product } from 'src/entities/product/product';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit {

  searchText: string; 
  p: number=1;

  products: Product[];

  constructor(private cataService: CategoryService,
    private title: Title,
    private httpClient: HttpClient,
    private proSv: ProductService) { }

  ngOnInit(): void {
    this.title.setTitle('Home');
    this.getAllProduct();
  }

  getAllProduct(){
    this.proSv.getAllProduct().subscribe( data => {
      this.products = data;
    }, error => console.log(error))
  }



}
