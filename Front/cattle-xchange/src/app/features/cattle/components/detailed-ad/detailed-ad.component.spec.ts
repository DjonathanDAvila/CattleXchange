import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailedAdComponent } from './detailed-ad.component';

describe('DetailedAdComponent', () => {
  let component: DetailedAdComponent;
  let fixture: ComponentFixture<DetailedAdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetailedAdComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailedAdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
