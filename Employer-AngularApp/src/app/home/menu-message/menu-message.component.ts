import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Message } from 'src/app/model/message-model';
import { ModalMessageComponent } from '../modal-message/modal-message.component';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-menu-message',
  templateUrl: './menu-message.component.html',
  styleUrls: ['./menu-message.component.css']
})
export class MenuMessageComponent implements OnInit {


  public messages: Array<Message>;
  public allMessages: Array<Message>;
  constructor(private service: MessageService, private model: NgbModal) {
    this.service.getAllMessages().subscribe(el => {
      this.allMessages=el;
      this.messages = this.allMessages.filter(el => el.status=="Unread");
    });
   }

  ngOnInit(): void {
  }

  getOnlyUnread(){
    this.messages=this.allMessages.filter(el => el.status=="Unread");
  }

  getOnlyRead(){
    this.messages=this.allMessages.filter(el => el.status=="Read");
  }
  
  getAllMessages(){
     this.messages = this.allMessages;
  }

  openModal(content: string,id: number, index: number){
    const modalRef = this.model.open(ModalMessageComponent,{ centered: true});
     modalRef.componentInstance.content = content;
    let message = this.messages[index];
    message.status="Read";
    this.service.updateMessage(message,id).subscribe();
  }
}
