import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './client/home/home.component';
import { NotFoundComponent } from './client/not-found/not-found.component';
import { HttpClientModule } from '@angular/common/http';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { ProDetailsComponent } from './client/pro-details/pro-details.component';
import { CateProductComponent } from './client/cate-product/cate-product.component';
import { LoginComponent } from './client/login-logout/login.component';
import { RegistrationComponent } from './client/login-logout/registration.component';
import { UserUpdateComponent } from './client/login-logout/user-update.component';
import { ShoppingCartComponent } from './client/shopping-cart/shopping-cart.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    ProDetailsComponent,
    CateProductComponent,
    LoginComponent, 
    RegistrationComponent, UserUpdateComponent, ShoppingCartComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    Ng2SearchPipeModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
