import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyOperationsComponent } from './my-ads.component';

describe('MyOperationsComponent', () => {
  let component: MyOperationsComponent;
  let fixture: ComponentFixture<MyOperationsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MyOperationsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MyOperationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
