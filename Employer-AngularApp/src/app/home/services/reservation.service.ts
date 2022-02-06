import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from 'src/app/model/reservation-model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  public endpointReservation= 'http://localhost:8080/api/v1/reservation';

  constructor(private http: HttpClient) { }

  public getAllReservation(){
    // let reservations: Reservation[] = [];
    // this.http.get<Array<Reservation>>(this.endpointReservation).subscribe(content => 
    //   content.forEach(el => reservations.push(el))
    //   );
    //   return reservations;
    return this.http.get<Array<Reservation>>(this.endpointReservation);
  }

  public updateReservation(reservation: Reservation, id: number){
    return this.http.put<Reservation>(this.endpointReservation+"/"+id,reservation);
  }
}
