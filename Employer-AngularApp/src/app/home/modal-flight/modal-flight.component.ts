import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { numbers } from '@material/snackbar';
import { NgbActiveModal, NgbDate, NgbDatepicker, NgbDateStruct, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Flight } from 'src/app/model/flight-model';
import { ScheduleFlight } from 'src/app/model/schedule-flight-model';
import { Schedule } from 'src/app/model/schedule-model';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-modal-flight',
  templateUrl: './modal-flight.component.html',
  styleUrls: ['./modal-flight.component.css']
})
export class ModalFlightComponent implements OnInit {

  private anyData: any;
  private anyDataForm: number;
  public date: NgbDate | null;
  model: NgbDateStruct;
  day: string;
  hour: string;
  flight: Flight; 
  schId: number;
  scheduleFlight: ScheduleFlight ;
  validator: boolean=false;
  num: Array<number>;

  constructor(public activeModal: NgbActiveModal, private service: FlightService ) {
   this.num = Array.from(Array(24).keys());
   }

  ngOnInit(): void {
  }

  OnSubmit() {
    this.activeModal.close('bla'); //It closes successfully
  }

  clearDate(){
    this.date=null;
  }

  clearDay(){
    this.day=null;
  }

  clearHour(){
    this.hour=null;
  }

  addScheduleToFlight(){
    if(this.date == null || this.day == null || this.hour == null){
      this.validator = true;
    }
    this.service.getFlightByID(this.anyDataForm).subscribe(response => {
      if(!this.validator){
        let schedule = new Schedule(this.date.year+"-"+this.date.month+"-"+(this.date.day<10 ? "0"+this.date.day : this.date.day),this.day,this.hour);
        console.log(schedule);
        console.log("Response"+response.id);
      // response.schedule.push(schedule);
      //let schflgh=new ScheduleFlight(this.schId, response.id); this.schId=resp.id
      this.service.createSchedule(schedule).subscribe(resp => {
        this.scheduleFlight = new ScheduleFlight(resp.id,response.id);
        // this.scheduleFlight.id_Flight=response.id;
        // this.scheduleFlight.id_Schedule= resp.id;
        console.log("OVO JE SCHEDULE FLIGHT"+this.scheduleFlight.schedule_ID+"  "+this.scheduleFlight.flight_ID);
        this.service.createScheduleInFlight(this.scheduleFlight).subscribe(res =>
          console.log(res));
       });
      }  
      });
      
  }
}
