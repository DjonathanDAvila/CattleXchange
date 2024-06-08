import { Component, OnInit } from '@angular/core';
import { AdsService } from '../../../../services/ads/ads.service';
import { FilterService } from '../../../../services/filter/filter.service'; // Import the new service
import { CattleAd } from '../../../../model/cattleAd/cattle/cattleAd';
import { CattleAdsPage } from '../../../../model/cattleAd/page/cattlePage';

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

  constructor(private adsService: AdsService, private filterService: FilterService) {}

  ngOnInit(): void {
    this.fetchAds();

    // Subscribe to filter criteria changes
    this.filterService.getFilterCriteria().subscribe(criteria => {
      if (criteria) {
        this.filterBy(criteria.sex, criteria.cities, criteria.states, criteria.maxPrice);
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

  findAdById(id: string): void {
    // Your implementation for finding an ad by its id
  }

  onPageChange(event: any): void {
    this.fetchAds(event.pageIndex);
  }
}
