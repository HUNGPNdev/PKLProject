import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { SigupInfo } from 'src/entities/user/sigup-info';
import { UserInfo } from 'src/entities/user/user-infor';
import { UserService } from 'src/entities/user/user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html'
})
export class UserUpdateComponent implements OnInit {

  message = false;
  user: SigupInfo;
  constructor(
    private userSv: UserService,
    private title: Title
    ) { }

  ngOnInit(): void {
    this.title.setTitle('Update User');
    this.user = this.userSv.getUserInfo();
  }

  onSubmit() {
    this.user.role = ['user'];
    this.userSv.updateUser(this.user).subscribe();
    this.userSv.saveUserInfo(this.user);
    this.message = true;
    this.user = this.userSv.getUserInfo();
  }

}
