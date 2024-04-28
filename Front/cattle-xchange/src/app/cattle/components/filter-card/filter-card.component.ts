import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-filter-card',
  templateUrl: './filter-card.component.html',
  styleUrls: ['./filter-card.component.scss'],
})
export class FilterCardComponent {
  cities: string[] = ['São Paulo', 'Rio de Janeiro', 'Blumenau'];

  form: FormGroup;

  constructor(private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      sex: [],
      city: [],
      initialPrice: null,
      finalPrice: null,
    });
  }

  filter() {
    console.log(this.form.value);
  }
}
