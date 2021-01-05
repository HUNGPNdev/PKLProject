import { Component, OnInit } from '@angular/core';
import { Order } from 'src/app/entities/product/order';
import { ProductService } from 'src/app/entities/product/product.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html'
})
export class OrderComponent implements OnInit {

  od2: Order[];

  constructor(private proSv: ProductService) { }

  ngOnInit(): void {
    this.loadOrder();
  }

  loadOrder() {
    this.proSv.getListOrder().subscribe(data => {
      this.od2 = data;
    });
  }

  deleteById(id: number) {
    if (confirm('Đã hoàn thành đơn hàng?')) {
      this.proSv.deleteOrderById(id).subscribe();
    }
    setTimeout(() => {
      this.loadOrder();
    }, 500);

  }

}
