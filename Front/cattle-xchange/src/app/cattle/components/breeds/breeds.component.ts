import { Component } from '@angular/core';

@Component({
  selector: 'app-breeds',
  templateUrl: './breeds.component.html',
  styleUrl: './breeds.component.scss'
})
export class BreedsComponent {

  breeds: string[] = ['Angus', 'Nelore', 'Hereford', 'Brangus'];
}
