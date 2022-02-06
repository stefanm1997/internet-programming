export class ScheduleFlight{
    schedule_ID : number;
    flight_ID : number;

    constructor( id_Schedule : number ,id_Flight : number,){
        this.schedule_ID = id_Schedule;
        this.flight_ID = id_Flight;
    }
}