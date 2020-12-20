import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Banner } from 'src/entities/banner/banner';
import { Category } from 'src/entities/category';
import { CategoryService } from 'src/entities/category.service';
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
  banner: Banner[];
  src = "http://localhost:8080/image/";

  constructor(private cataService: CategoryService,
    private httpClient: HttpClient,
    private userSv: UserService
    ) { }

  ngOnInit(): void {
    this.getAllCata();
    this.getBannerStatusTrue();
    this.userInfo = this.userSv.getUserInfo();
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
