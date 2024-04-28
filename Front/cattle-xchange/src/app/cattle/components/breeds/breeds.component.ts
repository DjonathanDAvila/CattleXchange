import { Component } from '@angular/core';
import { Breed } from '../../model/breed';

@Component({
  selector: 'app-breeds',
  templateUrl: './breeds.component.html',
  styleUrl: './breeds.component.scss',
})
export class BreedsComponent {
  breeds: Breed[];

  constructor() {
    this.breeds = [
      {
        breedName: 'Angus',
        imageUrl:
          'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg',
      },
      {
        breedName: 'Nelore',
        imageUrl:
          'https://upload.wikimedia.org/wikipedia/commons/3/39/RIMA_FIV_NERU.jpg',
      },
      {
        breedName: 'Hereford',
        imageUrl:
          'https://upload.wikimedia.org/wikipedia/commons/c/cf/Hereford_bull_in_a_field_by_the_B4452_%28cropped%29.jpg',
      },
      {
        breedName: 'Limousin',
        imageUrl:
          'https://cdn.globalagmedia.com/uploads/files/breeds/LimousinBull.jpg',
      },
    ];
  }

  filterByBreed(breedName: string) {
    console.log(breedName);
  }
}
