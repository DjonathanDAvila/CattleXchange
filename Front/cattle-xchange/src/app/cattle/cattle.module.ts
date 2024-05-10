import { CommonModule } from '@angular/common';
import { NgModule, forwardRef } from '@angular/core';
import { NG_VALUE_ACCESSOR, ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { CattleRoutingModule } from './cattle-routing.module';
import { FilterCardComponent } from './components/filter-card/filter-card.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { BreedsComponent } from './components/breeds/breeds.component';
import { AdsComponent } from './components/ads/ads.component';


@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent,
    FilterCardComponent,
    BreedsComponent,
    AdsComponent
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
