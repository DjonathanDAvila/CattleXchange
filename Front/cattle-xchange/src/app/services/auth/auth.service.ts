import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { isBrowser } from '../utils/browser/is-browser';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private readonly BASE_URL = 'http://localhost:8080/auth';

  constructor(private http: HttpClient, private router: Router) {}

  login(email: string, password: string): Observable<any> {
    return this.http
      .post<any>(`${this.BASE_URL}/login`, { email, password })
      .pipe(
        tap((response) => {
          if (isBrowser()) {
            localStorage.setItem('token', response.token);
            console.log(localStorage.getItem('token'));
          }
        })
      );
  }

  logout(): void {
    if (isBrowser()) {
      localStorage.removeItem('token');
    }
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    return isBrowser() ? !!localStorage.getItem('token') : false;
  }

  getToken(): string | null {
    return isBrowser() ? localStorage.getItem('token') : null;
  }
}
