import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { Region } from '../../model/region/region';
import { State } from '../../model/state/state';

@Injectable({
  providedIn: 'root'
})
export class IbgeService {

  private readonly BASE_URL = 'https://servicodados.ibge.gov.br/api/v1/localidades';

  constructor(private http: HttpClient) { }

  getStates(): Observable<State[]> {
    return this.http.get<any[]>(`${this.BASE_URL}/estados`).pipe(
      map(response => response
        .map(state => ({
          name: state.nome,
          uf: state.sigla
        }))
        .sort((a, b) => a.name.localeCompare(b.name))
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

  getRegions(): Observable<Region[]> {
    return this.http.get<any[]>(`${this.BASE_URL}/distritos`).pipe(
      map(cities => cities
        .map(city => ({
          city: city.nome,
          state: city['municipio']['microrregiao']['mesorregiao']['UF']['nome'],
          uf: city['municipio']['microrregiao']['mesorregiao']['UF']['sigla']
        }))
        .sort((a, b) => a.city.localeCompare(b.city))
      )
    );
  }
}
