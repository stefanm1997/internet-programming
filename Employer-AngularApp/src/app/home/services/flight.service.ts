import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Flight } from 'src/app/model/flight-model';
import { ScheduleFlight } from 'src/app/model/schedule-flight-model';
import { Schedule } from 'src/app/model/schedule-model';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  public endpointFlight = 'http://localhost:8080/api/v1/flight';
  public endpointSCHFLG = 'http://localhost:8080/api/v1/scheduleflight';
  public endpointSchedule = 'http://localhost:8080/api/v1/schedule';

  constructor(private http: HttpClient) { }

  public getAllFlights(){
    // let flights: Array<Flight> = [];
    // this.http.get<Array<Flight>>(this.endpointFlight).subscribe(content => 
    //   content.forEach(el => flights.push(el))
    //   );
    //   return flights;
    return this.http.get<Array<Flight>>(this.endpointFlight);
  }

  public putScheduleInFlight(flight: Flight, id: number){
    return this.http.put<Flight>(this.endpointFlight+"/"+id,flight);
  }

  public getFlightByID(id: number){
    return this.http.get<Flight>(this.endpointFlight+"/"+id);
  }

  public createScheduleInFlight(schFlgh: ScheduleFlight){
    return this.http.post<ScheduleFlight>(this.endpointSCHFLG, schFlgh);
  }

  public createSchedule(schedule: Schedule){
    return this.http.post<Schedule>(this.endpointSchedule, schedule);
  }
}
