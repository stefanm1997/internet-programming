export class Message{
    id : number;
    subject : string;
    content : string;
    status : string;

    constructor( id : number,subject : string,content : string,status : string){
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.status = status;
    }
}