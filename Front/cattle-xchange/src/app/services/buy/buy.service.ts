import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { CreateBuyDTO } from '../../model/buy/dto/CreateBuyDTO';

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
}
