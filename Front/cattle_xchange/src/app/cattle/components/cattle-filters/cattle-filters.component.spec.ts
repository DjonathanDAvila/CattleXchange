import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CattleFiltersComponent } from './cattle-filters.component';

describe('CattleFiltersComponent', () => {
  let component: CattleFiltersComponent;
  let fixture: ComponentFixture<CattleFiltersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CattleFiltersComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CattleFiltersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
