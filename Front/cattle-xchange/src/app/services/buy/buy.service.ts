import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

import { CreateBuyDTO } from '../../model/buy/dto/CreateBuyDTO';
import { CattleBuy } from '../../model/buy/cattleBuy';

@Injectable({
  providedIn: 'root'
})
export class BuyService {

  private readonly BASE_URL = 'http://localhost:8080/cattlebuy';

  constructor(
    private http: HttpClient
  ) { }

  getAllBuysByUser() {

  }

  getBuyById() {

  }

  createBuy(dto: CreateBuyDTO): Observable<any> {
    return this.http.post<any>(`${this.BASE_URL}`, dto);
  }

  findByUser(userId: string): Observable<CattleBuy[]> {
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJsb3MuZmVycmVpcmFAZW1haWwuY29tIiwiaWF0IjoxNzE4NTc4NTE5LCJleHAiOjE3MTg1Nzk5NTl9.OERr81A_T81rl_1yV-Di_N8bOzuW9fkr0q5Sl_Z_wWA';
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });

    return this.http
      .get<{ content: CattleBuy[] }>(`${this.BASE_URL}/user`, {
        headers: headers,
        params: {
          userId: userId,
          page: '0',
          size: '10',
        },
      })
      .pipe(map((response) => response.content));
  }
}
