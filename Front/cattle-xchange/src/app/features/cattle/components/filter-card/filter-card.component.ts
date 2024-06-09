import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { IbgeService } from '../../../../services/ibge/ibge.service';
import { FilterService } from '../../../../services/filter/filter.service'; // Import the new service
import { State } from '../../../../model/state/state';

@Component({
  selector: 'app-filter-card',
  templateUrl: './filter-card.component.html',
  styleUrls: ['./filter-card.component.scss'],
})
export class FilterCardComponent implements OnInit {
  cities: string[] = [];
  states: State[] = [];
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private ibgeService: IbgeService,
    private filterService: FilterService
  ) {
    this.form = this.formBuilder.group({
      sex: [[]],
      cities: [[]],
      states: [[]],
      maxPrice: null,
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
    const formValues = this.form.value;
    this.filterService.setFilterCriteria({
      sex: formValues.sex,
      cities: formValues.cities,
      states: formValues.states,
      maxPrice: formValues.maxPrice
    });
  }
}
