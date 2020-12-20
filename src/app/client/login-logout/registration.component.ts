import { Component, OnInit } from '@angular/core';
import { SigupInfo } from 'src/entities/user/sigup-info';
import { UserService } from 'src/entities/user/user.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html'
})
export class RegistrationComponent implements OnInit {

  form: any = {};
  signupInfo: SigupInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
 
  constructor(
    private userSv: UserService
    ) { }
 
  ngOnInit() { }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SigupInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password
    );
 
    this.userSv.signUp(this.signupInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

}
