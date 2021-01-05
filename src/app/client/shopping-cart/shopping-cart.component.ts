import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'src/app/app.component';
import { Order } from 'src/entities/product/order';
import { Product } from 'src/entities/product/product';
import { ProductService } from 'src/entities/product/product.service';
import { UserService } from 'src/entities/user/user.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html'
})
export class ShoppingCartComponent implements OnInit {

  pro: Product[];
  total: number = 0;
  count: number = 0;
  pro_id: number[] = [];
  od: Order[];
  od2: Order[];

  constructor(
    private userSv: UserService,
    private proSv: ProductService,
    private app: AppComponent
  ) { }

  ngOnInit(): void {
    if(this.userSv.getUserInfo().id != null) {
      this.loadCart();
      this.loadOrder(this.userSv.getUserInfo().id);
    }
  }

  loadCart() {
    this.proSv.getProductByUserId(this.userSv.getUserInfo().id).subscribe( data => {
      this.pro = data;
      this.total = 0;
      data.forEach( c => {
        this.total += c.count * c.price;
      });
    });
  }

  saverange(e: any, id: number) {
    const uploadData = new FormData();
    uploadData.append('user_id', this.userSv.getUserInfo().id);
    uploadData.append('count', e.target.value);
    this.proSv.updateCart(id, uploadData).subscribe();
    setTimeout(() =>{
      this.loadCart();
    }, 500 )
  }

  deleteCart(pro_id: number) {
    if(confirm('Bạn có chắc muốn xóa?')) {
      this.proSv.deleteCart(this.userSv.getUserInfo().id, pro_id).subscribe( data => {
        this.app.changeCount();
        this.loadCart();
      });
    }
  }

  order() {
    this.proSv.getOrderByUserId(this.userSv.getUserInfo().id).subscribe( data => {
      this.od = data;
      // console.log(data);
      this.proSv.orderPro(this.userSv.getUserInfo().id, this.od).subscribe();
    });
    this.loadCart();
    this.loadOrder(this.userSv.getUserInfo().id);
  }

  loadOrder(id: number) {
    this.proSv.getListOrder(id).subscribe( data => {
      this.od2 = data;
    });
  }

}
