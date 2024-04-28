import { Component } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';

@Component({
  selector: 'app-filter-card',
  templateUrl: './filter-card.component.html',
  styleUrl: './filter-card.component.scss',
})
export class FilterCardComponent {
  cities: string[] = ['São Paulo', 'Rio de Janeiro', 'Blumenau'];

  form = this.formBuilder.group({
    sex: [[]],
    city: [''],
  });

  constructor(private formBuilder: NonNullableFormBuilder) {}
}
