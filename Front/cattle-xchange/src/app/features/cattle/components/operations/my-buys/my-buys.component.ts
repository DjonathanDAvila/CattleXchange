import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';

import { CattleBuy } from '../../../../../model/buy/cattleBuy';
import { BuyService } from '../../../../../services/buy/buy.service';

@Component({
  selector: 'app-my-buys',
  templateUrl: './my-buys.component.html',
  styleUrl: './my-buys.component.scss',
})
export class MyBuysComponent implements OnInit {
  cattleBuys: Observable<CattleBuy[]>;

  readonly displayedColumns = [
    'codBuy',
    'dateBuy',
    'totalValue',
    'itemsBuy'
  ];

  constructor(
    private buyService: BuyService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.cattleBuys = buyService.findAllByUser();
  }

  ngOnInit(): void {}

  onDetails(buyId: string) {
    this.router.navigate(['ad-details', buyId]);
  }
}
