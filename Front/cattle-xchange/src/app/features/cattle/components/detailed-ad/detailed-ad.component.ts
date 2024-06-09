import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { CattleAd } from '../../../../model/cattleAd/cattle/cattleAd';
import { AdsService } from '../../../../services/ads/ads.service';

@Component({
  selector: 'app-detailed-ad',
  templateUrl: './detailed-ad.component.html',
  styleUrls: ['./detailed-ad.component.scss']
})
export class DetailedAdComponent implements OnInit {
  ad: CattleAd | undefined;

  constructor(
    private route: ActivatedRoute,
    private adsService: AdsService
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const adId = params.get('id');

      if (adId) {
        this.adsService.findById(adId).subscribe(data => {
          this.ad = data;
        });
      }
    });
  }
}
