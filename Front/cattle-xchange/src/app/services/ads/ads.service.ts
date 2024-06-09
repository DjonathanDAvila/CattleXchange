import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CattleAdsPage } from '../../model/cattleAd/page/cattlePage';

@Injectable({
  providedIn: 'root',
})
export class AdsService {
  private readonly BASE_URL = 'http://localhost:8080/cattle';

  constructor(private http: HttpClient) {}

  searchCattleAds(
    sex?: string[],
    cities?: string[],
    states?: string[],
    maxPrice?: number,
    breed?: string,
    sort?: string,
    page: number = 0,
    size: number = 10
  ): Observable<CattleAdsPage> {
    let params = new HttpParams();

    if (cities) cities.forEach(c => params = params.append('cities', c));
    if (states) states.forEach(s => params = params.append('states', s));
    if (maxPrice !== undefined && maxPrice !== null) params = params.append('maxPrice', maxPrice.toString());
    if (breed) params = params.append('breed', breed);
    if (sex) sex.forEach(s => params = params.append('sex', s));
    if (sort) params = params.append('sort', sort);
    params = params.append('page', page.toString());
    params = params.append('size', size.toString());

    return this.http.get<CattleAdsPage>(`${this.BASE_URL}/search`, { params });
  }
}
