import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-reservation',
  templateUrl: './modal-reservation.component.html',
  styleUrls: ['./modal-reservation.component.css']
})
export class ModalReservationComponent implements OnInit {

  public reason: string;
  public validator: boolean = false;
  constructor(private activeModel: NgbActiveModal) { }

  ngOnInit(): void {
  }

  onClose(){
    if(this.reason != null){
      console.log(this.reason);
      this.activeModel.close(this.reason);
    }
      
      else
      this.validator=true;
  }
}
