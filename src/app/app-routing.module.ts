import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CateProductComponent } from './client/cate-product/cate-product.component';
import { HomeComponent } from './client/home/home.component';
import { LoginComponent } from './client/login-logout/login.component';
import { RegistrationComponent } from './client/login-logout/registration.component';
import { UserUpdateComponent } from './client/login-logout/user-update.component';
import { NotFoundComponent } from './client/not-found/not-found.component';
import { ProDetailsComponent } from './client/pro-details/pro-details.component';
import { ShoppingCartComponent } from './client/shopping-cart/shopping-cart.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: '',component:HomeComponent},
  {path: 'product-detail/:id', component: ProDetailsComponent},
  {path: 'cate-product/:id', component: CateProductComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: 'user-update', component: UserUpdateComponent},
  {path: 'shopping-cart', component: ShoppingCartComponent},
  {path: '**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
