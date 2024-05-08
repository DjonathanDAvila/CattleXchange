import { Component } from '@angular/core';
import { CattleAd } from '../../../model/cattleAd/cattleAd';
import { Sex } from '../../../model/cattleAd/enum/sex';
import { CattleAdStatus } from '../../../model/cattleAd/enum/cattleAdStatus';

@Component({
  selector: 'app-ads',
  templateUrl: './ads.component.html',
  styleUrl: './ads.component.scss'
})
export class AdsComponent {

  ads: CattleAd[] = [];

  constructor() {
    this.onInit()
  }

  onInit() {
    this.findAllAds();
  }

  findAllAds() {
    this.ads = [
      {
        id: '1',
        title: 'Angus Bull',
        description: 'High-quality Angus bull for sale',
        unitValue: 1500,
        quantity: 1,
        breed: 'Angus',
        sex: Sex.M,
        announcer: 'John Doe',
        city: 'São Paulo',
        state: 'SP',
        creationDate: new Date('2024-04-25'),
        status: CattleAdStatus.ACTIVE,
        images: [
          { id: '1', sequence: 1, url: 'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg' },
          { id: '2', sequence: 2, url: 'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg' }
        ]
      },
      {
        id: '2',
        title: 'Hereford Heifer',
        unitValue: 1200,
        quantity: 2,
        breed: 'Hereford',
        sex: Sex.F,
        announcer: 'Jane Smith',
        city: 'Rio de Janeiro',
        state: 'RJ',
        status: CattleAdStatus.ACTIVE,
        images: [
          { id: '3', sequence: 1, url: 'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg' }
        ]
      },
      {
        id: '3',
        title: 'Limousin Bull',
        unitValue: 1800,
        quantity: 1,
        breed: 'Limousin',
        sex: Sex.M,
        announcer: 'Alice Johnson',
        city: 'Blumenau',
        state: 'SC',
        creationDate: new Date('2024-04-24'),
        status: CattleAdStatus.ACTIVE,
        images: [
          { id: '4', sequence: 1, url: 'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg' }
        ]
      },
      {
        id: '4',
        title: 'Holstein Cow',
        unitValue: 1000,
        quantity: 3,
        breed: 'Holstein',
        sex: Sex.F,
        announcer: 'Bob Brown',
        city: 'Porto Alegre',
        state: 'RS',
        creationDate: new Date('2024-04-23'),
        status: CattleAdStatus.INACTIVE,
        images: [
          { id: '6', sequence: 1, url: 'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg' }
        ]
      },
      {
        id: '5',
        title: 'Charolais Bull',
        unitValue: 2000,
        quantity: 1,
        breed: 'Charolais',
        sex: Sex.M,
        announcer: 'Eva Martinez',
        city: 'Curitiba',
        state: 'PR',
        status: CattleAdStatus.SOLDED,
        images: [
          { id: '5', sequence: 1, url: 'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg' }
        ]
      }
    ]
  }

  findAdById(id: string) {
    console.log(id);
  }
}
