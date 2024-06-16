import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CattleAd } from '../../../../../model/cattleAd/cattle/cattleAd';
import { AdsService } from '../../../../../services/ads/ads.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-my-operations',
  templateUrl: './my-ads.component.html',
  styleUrl: './my-ads.component.scss',
})
export class MyOperationsComponent implements OnInit {
  cattleAds: Observable<CattleAd[]>;

  constructor(
    private adsService: AdsService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.cattleAds = adsService.findByUser(
      'fde0783e-2b54-11ef-9260-0ccc47e06b45'
    );
  }

  readonly displayedColumns = ['title', 'creationDate', 'status', 'actions'];

  ngOnInit(): void {}

  onDetails(adId: string) {
    this.router.navigate(['ad-details', adId]);
  }
}
