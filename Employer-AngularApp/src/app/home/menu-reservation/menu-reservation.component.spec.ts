import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuReservationComponent } from './menu-reservation.component';

describe('MenuReservationComponent', () => {
  let component: MenuReservationComponent;
  let fixture: ComponentFixture<MenuReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuReservationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
