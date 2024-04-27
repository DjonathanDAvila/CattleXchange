import { Component } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  cities: string[] = ['São Paulo', 'Rio de Janeiro', 'Blumenau']

  form = this.formBuilder.group({
    sex: [[]],
    city: [''],
  });


  constructor(
    private formBuilder: NonNullableFormBuilder
  ) {}
}
