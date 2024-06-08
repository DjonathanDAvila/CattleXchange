import { Component } from '@angular/core';
import { Breed } from '../../../../model/cattleAd/cattle/breed';

@Component({
  selector: 'app-breeds',
  templateUrl: './breeds.component.html',
  styleUrl: './breeds.component.scss',
})
export class BreedsComponent {
  breeds: Breed[] = [];

  constructor() {
    this.getBreeds();
  }

  getBreeds() {
    this.breeds = [
      {
        breedName: 'Angus',
        imageUrl:
          'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg',
      },
      {
        breedName: 'Nelore',
        imageUrl:
          'https://semex.com.br/sites/default/files/styles/foto_touro_principal/public/corte/Gladiador-SITE0921.jpg?itok=Uo19uot9',
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
