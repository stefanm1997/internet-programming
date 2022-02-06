export class User{
    id: number;
    username : string;
    password : string;
    firstname: string;
    lastname: string;
    public isLogged: boolean = false;

    constructor(username : string,password : string, id?: number,firstname?: string,lastname?: string){
        this.username = username;
        this.password = password;
        if(id){
            this.id = id;
        }
        if(firstname){
            this.firstname = firstname;
        }
        if(lastname){
            this.lastname = lastname;
        }
    }

}