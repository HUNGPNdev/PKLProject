import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MixupComponent } from './admin/mixup/mixup.component';
import { ListCategoryComponent } from './admin/category/list-category/list-category.component';
import { ListProductComponent } from './admin/product/list-product/list-product.component';
import { CreateProductComponent } from './admin/product/create-product/create-product.component';
import { PageNotFound } from './admin/mixup/not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BannerComponent } from './admin/banner/banner.component';
import { LoadImageComponent } from './admin/mixup/load-image/load-image.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { httpInterceptorProviders } from './entities/auth/auth-interceptor';
import { LoginComponent } from './test/login/login.component';
import { RegisterComponent } from './test/register/register.component';
import { HomeComponent } from './test/home/home.component';
import { UserComponent } from './test/user/user.component';
import { AdminComponent } from './test/admin/admin.component';
import { UserUpdateComponent } from './test/user/user-update/user-update.component';
import { OrderComponent } from './admin/order/order.component';


@NgModule({
  declarations: [
    AppComponent,
    MixupComponent,
    ListCategoryComponent,
    ListProductComponent,
    CreateProductComponent,
    PageNotFound,
    BannerComponent,
    LoadImageComponent,
    // test
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    UserComponent,
    AdminComponent,
    UserUpdateComponent,
    OrderComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    AppRoutingModule,
    Ng2SearchPipeModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
