import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { response } from 'express';

import { CattleAd } from '../../../../model/cattleAd/cattle/cattleAd';
import { CattleAdsPage } from '../../../../model/cattleAd/page/cattlePage';
import { AdsService } from '../../../../services/ads/ads.service';
import { FilterService } from '../../../../services/filter/filter.service';

@Component({
  selector: 'app-ads',
  templateUrl: './ads.component.html',
  styleUrls: ['./ads.component.scss'],
})
export class AdsComponent implements OnInit {

  ads: CattleAd[] = [];
  totalElements: number = 0;
  currentPage: number = 0;
  pageSize: number = 10;

  constructor(
    private adsService: AdsService,
    private filterService: FilterService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.fetchAds();

    // Subscribe to filter criteria changes
    this.filterService.getFilterCriteria().subscribe(criteria => {
      if (criteria) {
        this.filterBy(criteria.sex, criteria.cities, criteria.states, criteria.maxPrice, criteria.breed);
      }
    });
  }

  fetchAds(page: number = 0): void {
    this.adsService.searchCattleAds(undefined, undefined, undefined, undefined, undefined, undefined, page, this.pageSize)
      .subscribe((response: CattleAdsPage) => {
        this.ads = response.content;
        this.totalElements = response.totalElements;
        this.currentPage = response.number;
      });
  }

  filterBy(
    sex?: string[],
    cities?: string[],
    states?: string[],
    maxPrice?: number,
    breed?: string,
    sort?: string,
    page: number = 0,
    size: number = 10
  ): void {
    this.adsService.searchCattleAds(sex, cities, states, maxPrice, breed, sort, page, size)
      .subscribe((response: CattleAdsPage) => {
        this.ads = response.content;
        this.totalElements = response.totalElements;
        this.currentPage = response.number;
      });
  }

  detail(id: string): void {
    this.router.navigate(['/ad-details', id]);
  }

  onPageChange(event: any): void {
    this.fetchAds(event.pageIndex);
  }
}
