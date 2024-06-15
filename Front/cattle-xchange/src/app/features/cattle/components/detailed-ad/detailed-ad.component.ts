import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CattleAd } from '../../../../model/cattleAd/cattle/cattleAd';
import { AdsService } from '../../../../services/ads/ads.service';

@Component({
  selector: 'app-detailed-ad',
  templateUrl: './detailed-ad.component.html',
  styleUrls: ['./detailed-ad.component.scss']
})
export class DetailedAdComponent implements OnInit {

  ad: CattleAd | undefined;
  totalbuyValue: number = 0;

  constructor(
    private route: ActivatedRoute,
    private adsService: AdsService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const adId = params.get('id');

      if (adId) {
        this.adsService.findById(adId).subscribe(data => {
          this.ad = data;
          this.totalbuyValue = this.calculateBuy(this.ad.unitValue, this.ad.quantity);
        });
      }
    });
  }

  protected isAdValid(): boolean {
    return !!this.ad && !!this.ad.cattleAdImages && this.ad.cattleAdImages.length > 0;
  }

  private calculateBuy(unitValue: number, quantity: number): number {
    return unitValue * quantity;
  }

  protected buy(ad: CattleAd, totatlBuyValue: number): void {

  }

  back(): void {
    this.router.navigate(['']);
  }
}
