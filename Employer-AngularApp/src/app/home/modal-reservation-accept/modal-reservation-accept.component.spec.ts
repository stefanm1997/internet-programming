import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalReservationAcceptComponent } from './modal-reservation-accept.component';

describe('ModalReservationAcceptComponent', () => {
  let component: ModalReservationAcceptComponent;
  let fixture: ComponentFixture<ModalReservationAcceptComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalReservationAcceptComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalReservationAcceptComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
