import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { IbgeService } from '../../../../services/ibge/ibge.service';

@Component({
  selector: 'app-filter-card',
  templateUrl: './filter-card.component.html',
  styleUrls: ['./filter-card.component.scss'],
})
export class FilterCardComponent implements OnInit {
  cities: string[] = [];
  states: string[] = [];
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private ibgeService: IbgeService
  ) {
    this.form = this.formBuilder.group({
      sex: [],
      city: [],
      state: [],
      finalPrice: null,
    });
  }

  ngOnInit(): void {
    this.loadStates();
    this.loadCities();
  }

  loadStates(): void {
    this.ibgeService.getStates().subscribe((data) => {
      this.states = data;
    });
  }

  loadCities(): void {
    this.ibgeService.getCities().subscribe((data) => {
      this.cities = data;
    });
  }

  filter(): void {
    console.log(this.form.value);
  }
}
