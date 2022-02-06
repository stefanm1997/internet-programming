import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from 'src/app/model/message-model';

@Injectable({
  providedIn: 'root'
})
export class MessageService {


  public endpointMessage= 'http://localhost:8080/api/v1/message';

  constructor(private http: HttpClient) { }

  public getAllMessages(){
    return this.http.get<Array<Message>>(this.endpointMessage);
  }

  public updateMessage(message: Message, id: number){
    return this.http.put<Message>(this.endpointMessage+"/"+id,message);
  }
}
