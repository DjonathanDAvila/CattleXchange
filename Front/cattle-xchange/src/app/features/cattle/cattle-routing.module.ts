import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/auth/login/login.component';
import { DetailedAdComponent } from './components/detailed-ad/detailed-ad.component';
import { HomeComponent } from './components/home/home.component';
import { MyOperationsComponent } from './components/operations/my-ads/my-ads.component';
import { MyBuysComponent } from './components/operations/my-buys/my-buys.component';
import { AnnounceComponent } from './components/announce/announce.component';
import { UserRegistrationComponent } from './components/user/user-registration/user-registration.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'ad-details/:id', component: DetailedAdComponent },
  { path: 'operations/myAds', component: MyOperationsComponent },
  { path: 'operations/myBuys', component: MyBuysComponent },
  { path: 'announce', component: AnnounceComponent },
  { path: 'userRegistration', component: UserRegistrationComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CattleRoutingModule {}
