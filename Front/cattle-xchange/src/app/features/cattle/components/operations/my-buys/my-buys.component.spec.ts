import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyBuysComponent } from './my-buys.component';

describe('MyBuysComponent', () => {
  let component: MyBuysComponent;
  let fixture: ComponentFixture<MyBuysComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyBuysComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(MyBuysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
