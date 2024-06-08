import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class FilterService {
  private filterCriteriaSubject = new BehaviorSubject<any>(null);

  setFilterCriteria(criteria: any): void {
    this.filterCriteriaSubject.next(criteria);
  }

  getFilterCriteria(): Observable<any> {
    return this.filterCriteriaSubject.asObservable();
  }
}
