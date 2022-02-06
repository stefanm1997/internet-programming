import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuFlightComponent } from './menu-flight.component';

describe('MenuFlightComponent', () => {
  let component: MenuFlightComponent;
  let fixture: ComponentFixture<MenuFlightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MenuFlightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuFlightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
