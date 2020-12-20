import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/entities/category/category';
import { CategoryService } from 'src/app/entities/category/category.service';
import { Product } from 'src/app/entities/product/product';
import { ProductService } from 'src/app/entities/product/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styles: [`
    select.ng-invalid.ng-touched {
      border: 2px solid red;
    }
  `]
})
export class CreateProductComponent implements OnInit {
  form: any = {};
  product: Product = new Product();
  category: Category[];
  selectedFile: any;
  id: number;
  src = "./assets/admin/img/new_seo-10-512.png";
  img = File;

  constructor(private proSv: ProductService,
    private cateSv: CategoryService,
    private router: Router,
    private route: ActivatedRoute,
    private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getAllCate();
    this.id = this.route.snapshot.params['id'];
    if(this.id != null) {
      this.getProById(this.id);
    } else {
      console.log("null");
    }
  }

  getProById(id: number) {
    this.proSv.getProById(id).subscribe( data => {
      this.product = data;
      this.src = "http://localhost:8080/image/"+this.product.image;
    })
  }

  getAllCate() {
    this.cateSv.listCategory().subscribe( data => {
      this.category = data;
    }, error => console.log(error))
  }

  
  onSubmit() {
    const uploadData = new FormData();
    if (this.selectedFile == null) {
      uploadData.append('product', JSON.stringify(this.product));
    } else {
      uploadData.append('file', this.selectedFile, this.selectedFile.name);
      uploadData.append('product', JSON.stringify(this.product));
    }

    if(this.id != null) {
      this.proSv.updateProById(uploadData).subscribe( data => {
      }, error => console.log(error))
    } else {
      this.proSv.createProduct(uploadData).subscribe( data => {
        this.router.navigate(['/admin/list-product']);
      }, error => console.log(error))
    }
  }

  onChangeFile(event) {
    this.selectedFile = event.target.files[0];
  }




}
