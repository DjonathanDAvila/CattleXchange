import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { CattleFiltersComponent } from './cattle/components/cattle-filters/cattle-filters.component';
import { HeaderComponent } from './cattle/components/header/header.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HeaderComponent,
    CattleFiltersComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent {
  title = 'cattle_xchange';
}
