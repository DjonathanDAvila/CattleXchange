import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CattleAd } from '../../../../model/cattleAd/cattle/cattleAd';
import { AdsService } from '../../../../services/ads/ads.service';
import { AuthService } from '../../../../services/auth/auth.service';
import { BuyService } from '../../../../services/buy/buy.service';
import { CreateBuyDTO } from '../../../../model/buy/dto/CreateBuyDTO';
import { Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CattleAdStatus } from '../../../../model/cattleAd/enum/cattleAdStatus';

@Component({
  selector: 'app-detailed-ad',
  templateUrl: './detailed-ad.component.html',
  styleUrls: ['./detailed-ad.component.scss']
})
export class DetailedAdComponent implements OnInit {
  ad: CattleAd | undefined;
  totalbuyValue: number = 0;
  CattleAdStatus = CattleAdStatus;

  constructor(
    private route: ActivatedRoute,
    private adsService: AdsService,
    private router: Router,
    private auth: AuthService,
    private buyService: BuyService,
    private location: Location,
    private snackBar: MatSnackBar,
  ) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const adId = params.get('id');

      if (adId) {
        this.adsService.findById(adId).subscribe(data => {
          this.ad = data;
          console.log(this.ad.status);
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

  protected buy(ad: CattleAd): void {
    if (!this.auth.isAuthenticated()) {
      const snackBarRef = this.snackBar.open('É necessário estar logado para poder comprar!', 'FAZER LOGIN', { duration: 7000 });
      snackBarRef.onAction().subscribe(() => this.router.navigate(['/login']));
      return;
    }

    const buyer = this.auth.getToken();
    if (buyer && ad) {
      const buyDTO: CreateBuyDTO = {
        codUser: buyer,
        listCodAds: [ad.id],
        dataBuy: new Date()
      };

      this.buyService.createBuy(buyDTO).subscribe({
        next: () => this.onSuccess(),
        error: (err) => this.onError(err.message)
      });
    }
  }

  private onSuccess() {
    this.snackBar.open('Compra realizada com sucesso!', '', { duration: 7000 });
    this.router.navigate(['operations/myBuys'])
  }

  private onError(error: string) {
    this.snackBar.open(`Não foi possível realizar sua compra! ${error}`, '', { duration: 7000 });
  }

  back(): void {
    this.location.back();
  }
}
