import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalFlightComponent } from './modal-flight.component';

describe('ModalFlightComponent', () => {
  let component: ModalFlightComponent;
  let fixture: ComponentFixture<ModalFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModalFlightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModalFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
