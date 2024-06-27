import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../model/user/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly BASE_URL = 'http://localhost:8080/auth/register';

  constructor(
    private http: HttpClient
  ) { }

  save(record: Partial<User>) {
    return this.http.post<User>(this.BASE_URL, record);
  }
}
