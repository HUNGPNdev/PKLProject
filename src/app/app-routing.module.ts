import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BannerComponent } from './admin/banner/banner.component';
import { ListCategoryComponent } from './admin/category/list-category/list-category.component';
import { MixupComponent } from './admin/mixup/mixup.component';
import { PageNotFound } from './admin/mixup/not-found.component';
import { OrderComponent } from './admin/order/order.component';
import { CreateProductComponent } from './admin/product/create-product/create-product.component';
import { ListProductComponent } from './admin/product/list-product/list-product.component';
import { AdminComponent } from './test/admin/admin.component';
import { HomeComponent } from './test/home/home.component';
import { LoginComponent } from './test/login/login.component';
import { RegisterComponent } from './test/register/register.component';
import { UserUpdateComponent } from './test/user/user-update/user-update.component';
import { UserComponent } from './test/user/user.component';

const routes: Routes = [
  {path: 'admin/list-category', component: ListCategoryComponent},
  {path: 'admin/list-category/:id', component: ListCategoryComponent},
  // product
  {path: 'admin/list-product', component: ListProductComponent},
  {path: 'admin/create-product', component: CreateProductComponent},
  {path: 'admin/update-product/:id', component: CreateProductComponent},

  {path: 'admin/banner', component: BannerComponent},
  {path: 'admin/banner/:id', component: BannerComponent},

  {path: 'admin/home', component: MixupComponent},
  {path: '', component: MixupComponent},
//   {path: 'admin', redirectTo: 'admin/home', pathMatch: 'full'},

  // test
  { path: 'home', component: HomeComponent },
  { path: 'admin/user-update/:id', component: UserUpdateComponent },
  { path: 'admin/user-list', component: UserComponent },
  { path: 'admin/user-create', component: RegisterComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'auth/login', component: LoginComponent },
  { path: 'auth/order', component: OrderComponent },
  { path: '**', component: PageNotFound }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
