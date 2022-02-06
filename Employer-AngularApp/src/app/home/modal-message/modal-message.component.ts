import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-modal-message',
  templateUrl: './modal-message.component.html',
  styleUrls: ['./modal-message.component.css']
})
export class ModalMessageComponent implements OnInit {

  public content: string;

  constructor(private activeModel: NgbActiveModal) { }

  ngOnInit(): void {
  }

  onClose(){
    this.activeModel.close("bla");
}
}
