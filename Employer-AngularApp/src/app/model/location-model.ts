
export class Location{
    id : number;
    country : string;
    iso2 : string;
    iso3 : string;

    constructor( id : number,country : string,iso2 : string,iso3 : string){
        this.id = id;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
    }
}