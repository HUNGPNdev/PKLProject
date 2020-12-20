import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/entities/auth/token-storage.service';
import { UserInfo } from 'src/app/entities/auth/user-infor';
import { UserService } from 'src/app/entities/auth/user.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html'
})
export class UserComponent implements OnInit {

  users: UserInfo[];
  errorMessage: string;
  username: string;
 
  constructor(private userService: UserService, private router: Router,
    private token: TokenStorageService,
    private title: Title) { }
 
  ngOnInit() {
    this.title.setTitle('User List');
    this.userService.getUserBoard().subscribe(
      data => {
        this.users = data;
      },
      error => {
        this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
      }
    );
    this.username = this.token.getUsername();
  }

  goToUpdate(id: number) {
    this.router.navigate(['admin/user-update/', id]);
  }
 
  deleteById(id: number) {
    if(confirm('Bạn có chắc muốn xóa người này?')) {
      this.userService.deleteUserById(id).subscribe( data => {
        window.location.reload();
      });
    }
  }

}
