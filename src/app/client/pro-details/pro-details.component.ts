import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';
import { Cart } from 'src/entities/product/cart';
import { Product } from 'src/entities/product/product';
import { ProductService } from 'src/entities/product/product.service';
import { UserService } from 'src/entities/user/user.service';


@Component({
  selector: 'app-pro-details',
  templateUrl: './pro-details.component.html'
})
export class ProDetailsComponent implements OnInit {
  pro: Product;

  constructor(private title: Title,
    private route: ActivatedRoute,
    private userSv: UserService,
    private router: Router,
    private app: AppComponent,
    private proSv: ProductService
  ) { }

  ngOnInit(): void {
    this.title.setTitle("Details");
    this.getProductById(this.route.snapshot.params['id']);
  }

  getProductById(id: number) {
    this.proSv.getProductById(id).subscribe(data => {
      this.pro = data;
    }, error => console.log(error));
  }

  addToCart(id: number) {
    if (this.userSv.getUserInfo().id != null) {
      this.proSv.addCart(new Cart(this.userSv.getUserInfo().id, id)).subscribe();
      setTimeout(() => {
      this.app.changeCount();
      this.router.navigate(['shopping-cart']);
      }, 500);
    } else {
      alert('Vui lòng đăng nhập!');
    }

  }

}
