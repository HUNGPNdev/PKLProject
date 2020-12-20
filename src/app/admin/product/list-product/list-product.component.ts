import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { Product } from 'src/app/entities/product/product';
import { ProductService } from 'src/app/entities/product/product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html'
})
export class ListProductComponent implements OnInit {
  searchText: string;
  p:number=1;
  products: Product[];
  product: Product = new Product();

  constructor(private proSv : ProductService,
    private router: Router,
    private title: Title) { }

  ngOnInit(): void {
    this.getAllProduct();
    this.title.setTitle('Product-List');
  }

  getAllProduct() {
    this.proSv.getAllProduct().subscribe( data => {
      this.products = data;
    }, error => console.log(error))
  }

  goToUpdate(id: number) {
    this.router.navigate(['/admin/update-product', id]);
  }

  deleteById(id: number) {
    if(confirm('Bạn có chắc chắn muốn xóa?')) {
      this.proSv.deleteById(id).subscribe( data => {
        this.getAllProduct();
      })
    }
  }

}
