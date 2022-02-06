import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-reservation-accept',
  templateUrl: './modal-reservation-accept.component.html',
  styleUrls: ['./modal-reservation-accept.component.css']
})
export class ModalReservationAcceptComponent implements OnInit {

  constructor(private activeModel: NgbActiveModal) { }

  ngOnInit(): void {
  }

  onClose(){
      this.activeModel.close("bla");
  }
}
