import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { NavigationEnd, Router } from '@angular/router';
import { Banner } from 'src/entities/banner/banner';
import { Category } from 'src/entities/category';
import { CategoryService } from 'src/entities/category.service';
import { ProductService } from 'src/entities/product/product.service';
import { UserInfo } from 'src/entities/user/user-infor';
import { UserService } from 'src/entities/user/user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-user';
  userInfo: UserInfo;
  categories: Category[];
  Count:any;
  banner: Banner[];
  src = "http://localhost:8080/image/";

  constructor(private cataService: CategoryService,
    private httpClient: HttpClient,
    private userSv: UserService,
    private proSv: ProductService,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.getAllCata();
    this.getBannerStatusTrue();
    this.userInfo = this.userSv.getUserInfo();
    this.changeCount();
  }



  changeCount() {
    // this.router.events.forEach( evt => {
    //   if(evt instanceof NavigationEnd) {
    //     if(this.userInfo.id != null) {
    //       this.Count = this.proSv.countCart(this.userInfo.id);
    //       this.proSv.countCart(this.userInfo.id).subscribe( data => {
    //         this.Count = data;
    //       })
    //     } else {
    //       this.Count = 0;
    //     }
    //   };
    // })
    if(this.userInfo.id != null) {
      this.Count = this.proSv.countCart(this.userInfo.id);
      this.proSv.countCart(this.userInfo.id).subscribe( data => {
        this.Count = data;
      })
    } else {
      this.Count = 0;
    }
  }

  getAllCata() {
    this.cataService.listCategory().subscribe( data => {
      this.categories = data;
    }, error => console.log(error))
  }
  
  logout() {
    this.userSv.signOut();
    location.reload();
  }

  getBannerStatusTrue() {
    this.httpClient.get<Banner[]>(`http://localhost:8080/user/bannerShow`).subscribe( data => {
      this.banner = data;
      for(let b of this.banner) {
        this.src = this.src+b.name;
        break;
      }
    })
  }
}
