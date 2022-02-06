import { Flight } from "./flight-model";
import { User } from "./user.model";

export class Reservation{
    id: number;
    status: string;
    date_creation: string;
    reason: string;
    flight: Flight;
    user: User;

    constructor( id : number,status : string,date_creation : string,flight : Flight,
        user : User, reason: string){
        this.id = id;
        this.status = status;
        this.date_creation = date_creation;
        this.flight = flight;
        this.user = user;
        this.reason = reason
    }
}