import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class IbgeService {

  private readonly BASE_URL = 'https://servicodados.ibge.gov.br/api/v1/localidades';

  constructor(private http: HttpClient) { }

  getStates(): Observable<string[]> {
    return this.http.get<any[]>(`${this.BASE_URL}/estados`).pipe(
      map(states => states
        .map(state => `${state.nome} - ${state.sigla}`)
        .sort((a, b) => a.localeCompare(b))
      )
    );
  }

  getCities(): Observable<string[]> {
    return this.http.get<any[]>(`${this.BASE_URL}/distritos`).pipe(
      map(cities => cities
        .map(city => city.nome)
        .sort((a, b) => a.localeCompare(b))
      )
    );
  }
}
