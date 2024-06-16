import { Component, OnInit } from '@angular/core';
import { BuyService } from '../../../../../services/buy/buy.service';
import { CattleBuy } from '../../../../../model/buy/cattleBuy';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemBuy } from '../../../../../model/buy/item-buy';

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
    this.cattleBuys = buyService.findByUser(
      'fde0783e-2b54-11ef-9260-0ccc47e06b45'
    );
  }

  ngOnInit(): void {}

  onDetails(buyId: string) {
    this.router.navigate(['ad-details', buyId]);
  }
}
