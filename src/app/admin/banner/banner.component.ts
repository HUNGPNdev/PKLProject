import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { Banner } from 'src/app/entities/banner/banner';
import { BannerService } from 'src/app/entities/banner/banner.service';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html'
})
export class BannerComponent implements OnInit {
  id: number;

  selectedFile: any;

  banner: Banner = new Banner();
  banners: Banner[];

  src = "./assets/admin/img/new_seo-10-512.png";


  constructor(private bannerService: BannerService,
    private httpClient: HttpClient,
    private title: Title,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.title.setTitle('Banner');
    this.getAllBanner();
    this.id = this.route.snapshot.params['id'];
    if (this.id != null) {
      this.getBannerById(this.id);
    }
  }

  getBannerById(id: number) {
    this.bannerService.getById(id).subscribe(data => {
      this.banner = data;
      this.src = "http://localhost:8080/image/" + this.banner.name;
    }, error => console.log(error))
  }

  getAllBanner() {
    this.bannerService.getAllBanner().subscribe(data => {
      this.banners = data;
    }, error => console.log(error))
  }

  updateById(id: number) {
    this.router.navigate(['admin/banner', id]);
    this.getBannerById(id);
  }

  deleteById(id: number) {
    if (confirm('Bạn có chắc chắn muốn xóa?')) {
      this.bannerService.deleteById(id).subscribe(data => {
        this.getAllBanner();
      })
    }
  }


  public onFileChanged(event) {
    this.selectedFile = event.target.files[0];
  }

  onSubmit() {
    const uploadData = new FormData();
    if (this.selectedFile == null) {
      uploadData.append('status', this.banner.status);
    } else {
      uploadData.append('myFile', this.selectedFile, this.selectedFile.name);
      uploadData.append('status', this.banner.status);
    }

    if (this.id != null) {
      this.bannerService.updateById(this.id, uploadData).subscribe(data => {
        this.router.navigate(['admin/banner']);
      }, error => console.log(error))
    } else {
      this.bannerService.createBanner(uploadData).subscribe(data => {
        this.getAllBanner();
        this.src = "./assets/admin/img/new_seo-10-512.png";
      }, error => console.log(error))
    }
  }



}
