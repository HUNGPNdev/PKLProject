import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { User } from 'src/entities/user/user';
import { UserInfo } from 'src/entities/user/user-infor';
import { UserService } from 'src/entities/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {
 
  form: any = {};
  isLoginFailed = false;
  loginInfo: User;
  userInfo: UserInfo;

  errorMessage = 'Sai tài khoản hoặc mật khẩu!';

  constructor(
    private userSv: UserService,
    private title: Title,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.title.setTitle('Login');
    this.userInfo = this.userSv.getUserInfo();
    if(this.userInfo.name != null) {
      this.router.navigate(['/']);
    }
   }

  onSubmit() {
    this.loginInfo = new User(
      this.form.username,
      this.form.password
    );
    this.userSv.attemptAuth(this.loginInfo).subscribe( data => {
      this.userSv.getUserByName(data.username).subscribe( data => {
        this.userSv.saveUserInfo(data);
        this.userInfo = this.userSv.getUserInfo();
      });
      window.location.reload();
    }, error => {
      // this.errorMessage = error.error.message;
      this.isLoginFailed = true;
    });
    
  }

  

}
