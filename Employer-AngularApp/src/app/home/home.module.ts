import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { MenuComponent } from './menu/menu.component';
import { ButtonsModule, DropdownModule, MDBBootstrapModule, NavbarComponent } from 'angular-bootstrap-md';
import { FormsModule, NgModel, ReactiveFormsModule } from '@angular/forms';
import { NavbarModule, WavesModule } from 'angular-bootstrap-md';
import { MenuFlightComponent } from './menu-flight/menu-flight.component';
import { HomeComponent } from './home/home.component'
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ModalFlightComponent } from './modal-flight/modal-flight.component';
import { MenuReservationComponent } from './menu-reservation/menu-reservation.component';
import { MenuMessageComponent } from './menu-message/menu-message.component';
import { ModalReservationComponent } from './modal-reservation/modal-reservation.component';
import { ModalReservationAcceptComponent } from './modal-reservation-accept/modal-reservation-accept.component';
import { ModalMessageComponent } from './modal-message/modal-message.component';


@NgModule({
  declarations: [MenuComponent, MenuFlightComponent, HomeComponent, ModalFlightComponent, MenuReservationComponent, MenuMessageComponent, ModalReservationComponent, ModalReservationAcceptComponent, ModalMessageComponent],
  imports: [
    CommonModule,
    HomeRoutingModule,  
    MDBBootstrapModule.forRoot(), NavbarModule, WavesModule, ButtonsModule, NgbModule,FormsModule,DropdownModule.forRoot()
  ]
})
export class HomeModule { }
