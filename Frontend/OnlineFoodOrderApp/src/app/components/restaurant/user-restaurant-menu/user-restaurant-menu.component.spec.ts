import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserRestaurantMenuComponent } from './user-restaurant-menu.component';

describe('UserRestaurantMenuComponent', () => {
  let component: UserRestaurantMenuComponent;
  let fixture: ComponentFixture<UserRestaurantMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserRestaurantMenuComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserRestaurantMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
