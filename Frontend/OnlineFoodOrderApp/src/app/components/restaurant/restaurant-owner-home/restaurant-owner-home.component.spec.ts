import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantOwnerHomeComponent } from './restaurant-owner-home.component';

describe('RestaurantOwnerHomeComponent', () => {
  let component: RestaurantOwnerHomeComponent;
  let fixture: ComponentFixture<RestaurantOwnerHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RestaurantOwnerHomeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RestaurantOwnerHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
