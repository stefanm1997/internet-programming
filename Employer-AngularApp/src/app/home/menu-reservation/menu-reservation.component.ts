import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { error } from 'protractor';
import {  Observable } from 'rxjs';
import { Reservation } from 'src/app/model/reservation-model';
import { ModalReservationAcceptComponent } from '../modal-reservation-accept/modal-reservation-accept.component';
import { ModalReservationComponent } from '../modal-reservation/modal-reservation.component';
import { ReservationService } from '../services/reservation.service';

@Component({
  selector: 'app-menu-reservation',
  templateUrl: './menu-reservation.component.html',
  styleUrls: ['./menu-reservation.component.css']
})
export class MenuReservationComponent implements OnInit {

  public value: string;
  public reservations: Reservation[];
  private allReservations: Reservation[];
  public reason: string;

  constructor(private service : ReservationService, private model: NgbModal) {
    this.service.getAllReservation().subscribe(el => {
      this.allReservations = el;
      this.reservations = this.allReservations.filter(el => el.status=="New");
    });
   }

  ngOnInit(): void {
   // this.allReservations = this.service.getAllReservation();
    //this.reservations.forEach(el => console.log(el.date_creation));
    //this.getOnlyNew();
    //this.reservations=this.allReservations.filter(el => el.status=="New");
  }

  getOnlyNew(){
  this.reservations=this.allReservations.filter(el => el.status=="New");
  }

  getAllReservations(){
    this.reservations=this.allReservations;
  }

  updateRes(id: number, index: number){
    let res = this.reservations[index];
    res.status = "Accepted";
    res.reason = "";
    this.service.updateReservation(res,id).subscribe();
    //console.log(res);
  }

  alertReservation(message: string){
    alert(message);
    
  }

  openModalAccept(id: number, index: number){
    const modalRef = this.model.open(ModalReservationAcceptComponent,{ centered: true});
    this.updateRes(id,index);
  }

  openModalDecline(id: number, index: number){
    //this.model.open(ModalFlightComponent);
     const modalRef = this.model.open(ModalReservationComponent,{ centered: true});
     modalRef.result.then(resp => {
      let res = this.reservations[index];
      res.status = "Declined";
      res.reason = resp;
      console.log(res.reason);
      this.service.updateReservation(res, id).subscribe();
     }).catch(error => console.log(error));
     
  }
}
