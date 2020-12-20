import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/entities/category/category';
import { CategoryService } from 'src/app/entities/category/category.service';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-create-category',
  templateUrl: './list-category.component.html',
})
export class ListCategoryComponent implements OnInit {

  id: number;
  category: Category = new Category();
  categories: Category[];

  constructor(private cataService: CategoryService,
    private router: Router,
    private title: Title,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.title.setTitle('Category');
    this.getAllCata();
    this.id = this.route.snapshot.params['id'];
    if(this.id != null) {
      this.getCateById(this.id);
    }
  }

  getAllCata() {
    this.cataService.listCategory().subscribe( data => {
      this.categories = data;
    }, error => console.log(error))
  }

  onSubmit() {
    if(this.id != null) {
      this.updateById();
    } else {
        this.createCategory();
    }
  }

  updateById() {
    this.cataService.updateById(this.id, this.category).subscribe( data => {
      this.router.navigate(['/admin/list-category']);
    }, error => console.log(error))
  }

  createCategory() {
    this.cataService.createCata(this.category).subscribe( data => {
      this.getAllCata();
    }, error => console.log(error));
  }

  getCateById(id: number) {
    this.cataService.getCateById(id).subscribe( data => {
      this.category = data;
      this.router.navigate(['admin/list-category', id]);
    })
  }
 
  deleteById(id: number) {
    this.cataService.deleteById(id).subscribe( data => {
      this.getAllCata();
    }, error => console.log(error))
  }

}
