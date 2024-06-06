import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CattleAd } from '../../model/cattleAd/cattleAd';

@Injectable({
  providedIn: 'root'
})
export class AdsService {

  private readonly BASE_URL = 'http://localhost:8080/cattle/';

  constructor(
    private http: HttpClient
  ) { }

  getCattleAds(): Observable<CattleAd[]> {
    return this.http.get<CattleAd[]>(this.BASE_URL);
  }
}
