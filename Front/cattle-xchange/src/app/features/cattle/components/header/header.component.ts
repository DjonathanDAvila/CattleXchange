import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../../../services/auth/auth.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
  isAuthenticated: boolean = false; // Initialize to false

  constructor(
    private router: Router,
    private auth: AuthService,
    private snackBar: MatSnackBar
  ) {}

  ngOnInit() {
    this.isAuthenticated = this.auth.isAuthenticated();
  }

  navigateTo(path: string) {
    this.router.navigate([path]);
  }

  navigateOrSnack(path: string) {
    if (this.isAuthenticated) {
      this.navigateTo(path);
    } else {
      this.showLoginSnackbar();
    }
  }

  showLoginSnackbar() {
    const snackRef = this.snackBar.open(
      'É necessário fazer o login para acessar esta aba!',
      'FAZER LOGIN',
      { duration: 7000 }
    );
    snackRef.onAction().subscribe(() => {
      this.navigateTo('/login');
    });
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['']);
  }
}
