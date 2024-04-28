import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { CattleRoutingModule } from './cattle-routing.module';
import { FilterCardComponent } from './components/filter-card/filter-card.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';


@NgModule({
  declarations: [
    HomeComponent,
    HeaderComponent,
    FilterCardComponent
  ],
  imports: [
    CommonModule,
    CattleRoutingModule,
    SharedModule,
    AppMaterialModule,
    ReactiveFormsModule
  ],
})
export class CattleModule { }
