import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, Router } from '@angular/router';
import { UserInfo } from 'src/app/entities/auth/user-infor';
import { UserService } from 'src/app/entities/auth/user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html' 
})
export class UserUpdateComponent implements OnInit {

  user: UserInfo;
  ROLE_ADMIN = true;
  ROLE_PM = true; 
  ROLE_USER = true;

  constructor(private route: ActivatedRoute,
    private userSv: UserService,
    private router: Router,
    private title: Title) { }

  ngOnInit(): void {
    this.title.setTitle('User-Update');
    this.userSv.getUserById(this.route.snapshot.params['id']).subscribe( data => {
      this.user = data;
      if(this.user.role.includes('ROLE_ADMIN')) {
        this.ROLE_ADMIN = false;
      } 
      if(this.user.role.includes('ROLE_PM')) {
        this.ROLE_PM = false;
      }
      if(this.user.role.includes('ROLE_USER')) {
        this.ROLE_USER = false;
      }
    }, error => console.log(error))
  }

  onSubmit() {
    console.log(this.user);
    this.userSv.updateUser(this.route.snapshot.params['id'], this.user).subscribe();
    this.router.navigate(['/admin/user-list']);
  }


}
