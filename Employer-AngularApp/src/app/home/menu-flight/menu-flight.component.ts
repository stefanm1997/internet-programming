import { Component, NgModule, OnInit, ViewChild } from '@angular/core';
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MDBModalRef, MDBModalService } from 'angular-bootstrap-md';
import { Observable } from 'rxjs';
import { Flight } from 'src/app/model/flight-model';
import { ModalFlightComponent } from '../modal-flight/modal-flight.component';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-menu-flight',
  templateUrl: './menu-flight.component.html',
  styleUrls: ['./menu-flight.component.css']
})
export class MenuFlightComponent implements OnInit {

  public flights : Array<Flight> = [];
  display = "none";
  closeModal: string;
  modal: ModalFlightComponent;
  constructor(private service: FlightService, private model: NgbModal) { }

  ngOnInit(): void {
    this.service.getAllFlights().subscribe(el => this.flights = el);
    console.log(this.flights);
    this.flights.forEach(content =>
      console.log("Daj nesto"+content)
    );
  }

  openModal(id: number){
    //this.model.open(ModalFlightComponent);
     const modalRef = this.model.open(ModalFlightComponent,{ centered: true});
     modalRef.componentInstance.anyDataForm = id;
  }
}
