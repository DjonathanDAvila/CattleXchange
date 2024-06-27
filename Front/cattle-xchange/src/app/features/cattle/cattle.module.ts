import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../../shared/app-material/app-material.module';
import { SharedModule } from '../../shared/shared.module';
import { CattleRoutingModule } from './cattle-routing.module';
import { AdsComponent } from './components/ads/ads.component';
import { LoginComponent } from './components/auth/login/login.component';
import { BreedsComponent } from './components/breeds/breeds.component';
import { DetailedAdComponent } from './components/detailed-ad/detailed-ad.component';
import { FilterCardComponent } from './components/filter-card/filter-card.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { MyOperationsComponent } from './components/operations/my-ads/my-ads.component';
import { MyBuysComponent } from './components/operations/my-buys/my-buys.component';
import { AnnounceComponent } from './components/announce/announce.component';
import { UserRegistrationComponent } from './components/user/user-registration/user-registration.component';


@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent,
    FilterCardComponent,
    BreedsComponent,
    AdsComponent,
    FooterComponent,
    LoginComponent,
    DetailedAdComponent,
    MyOperationsComponent,
    MyBuysComponent,
    AnnounceComponent,
    UserRegistrationComponent
  ],
  imports: [
    CommonModule,
    CattleRoutingModule,
    SharedModule,
    AppMaterialModule,
    ReactiveFormsModule
  ]

})
export class CattleModule { }
