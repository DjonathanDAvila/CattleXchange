import { Component, OnInit } from '@angular/core';

import { CattleAd } from '../../../../model/cattleAd/cattleAd';
import { AdsService } from '../../../../services/ads/ads.service';

@Component({
  selector: 'app-ads',
  templateUrl: './ads.component.html',
  styleUrls: ['./ads.component.scss']
})
export class AdsComponent implements OnInit {
  ads: CattleAd[] = [];

  constructor(private adsService: AdsService) { }

  ngOnInit(): void {
    this.fetchAds();
  }

  fetchAds(): void {
    this.adsService.getCattleAds().subscribe((ads: CattleAd[]) => {
      this.ads = ads;
    });
  }

  findAdById(id: string) {

  }
}
