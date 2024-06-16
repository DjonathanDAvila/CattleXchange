import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

import { CattleAd } from '../../model/cattleAd/cattle/cattleAd';
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

    if (cities) cities.forEach((c) => (params = params.append('cities', c)));
    if (states) states.forEach((s) => (params = params.append('states', s)));
    if (maxPrice !== undefined && maxPrice !== null)
      params = params.append('maxPrice', maxPrice.toString());
    if (breed) params = params.append('breed', breed);
    if (sex) sex.forEach((s) => (params = params.append('sex', s)));
    if (sort) params = params.append('sort', sort);
    params = params.append('page', page.toString());
    params = params.append('size', size.toString());

    return this.http.get<CattleAdsPage>(`${this.BASE_URL}/search`, { params });
  }

  findById(id: string) {
    return this.http.get<CattleAd>(`${this.BASE_URL}/${id}`);
  }

  findByUser(userId: string): Observable<CattleAd[]> {
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJsb3MuZmVycmVpcmFAZW1haWwuY29tIiwiaWF0IjoxNzE4NTc4NTE5LCJleHAiOjE3MTg1Nzk5NTl9.OERr81A_T81rl_1yV-Di_N8bOzuW9fkr0q5Sl_Z_wWA';
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });

    return this.http
      .get<{ content: CattleAd[] }>(`${this.BASE_URL}/user`, {
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
