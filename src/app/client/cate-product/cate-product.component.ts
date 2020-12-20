import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { CategoryService } from 'src/entities/category.service';
import { Product } from 'src/entities/product/product';

@Component({
  selector: 'app-cate-product',
  templateUrl: './cate-product.component.html'
})
export class CateProductComponent implements OnInit {

  products: Product[];
  p:number;
  searchText: string;

  constructor(private cateSv: CategoryService,
    private route: ActivatedRoute,
    private title: Title,
    private router: Router) {}

  ngOnInit(): void {
    this.title.setTitle('Categories');
    this.router.events.forEach(evt => {
      if (evt instanceof NavigationEnd) {
        this.getProByCateId(this.route.snapshot.params['id']);
      }
    })
    this.getProByCateId(this.route.snapshot.params['id']);
  }

  getProByCateId(id: number) {
    this.cateSv.getProByCateId(id).subscribe( data => {
      this.products = data;
    })
  }

}
