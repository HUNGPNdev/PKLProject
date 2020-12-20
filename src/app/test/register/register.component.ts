import { Component, OnInit } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { AuthService } from 'src/app/entities/auth/auth.service';
import { SignupInfo } from 'src/app/entities/auth/signup-info';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  signupInfo: SignupInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  success = '';

  constructor(private authService: AuthService,
    private title: Title
  ) { }

  ngOnInit() {
    this.title.setTitle('User-Create');
    this.form.role = ["user"];
  }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignupInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password,
      this.form.role
    );

    console.log(this.signupInfo);
    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        this.isSignUpFailed = true;
        this.errorMessage = "User registered successfully!";
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
