export class Schedule{
    id : number;
    date : string;
    day : string;
    hour : string;

    constructor(date : string,day : string,hour : string){
        this.date = date;
        this.day = day;
        this.hour = hour;
    }
}