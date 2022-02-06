import { Location } from "./location-model";
import { Schedule } from "./schedule-model";

export class Flight{
    id: number;
    status: string;
    type: string;
    start_location: Location;
    end_location: Location;
    schedule: Array<Schedule>;

    constructor( id : number,status : string,type : string,start_location : Location,
        end_location : Location,schedule: Array<Schedule>){
        this.id = id;
        this.status = status;
        this.type = type;
        this.start_location = start_location;
        this.end_location = end_location;
        this.schedule = schedule;
    }
}