import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { TokenStorageService } from './entities/auth/token-storage.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  title = 'AngularBoots';
  username = '';

  roles: string[] = [];
 
  constructor(private tokenStorage: TokenStorageService,
    private router: Router) { }
 
  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.username = this.tokenStorage.getUsername();
    }
  }

  logout() {
    this.tokenStorage.signOut();
    this.router.navigate(['/auth/login']);
    this.router.events.forEach( evt => {
      if(evt instanceof NavigationEnd) {
        location.reload();
      }
    });
    location.reload();
  }

}
