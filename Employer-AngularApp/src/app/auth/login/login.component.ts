import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';
import { LoginService } from '../services/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public form: FormGroup = new FormGroup({});
  public validator: boolean=false;
  constructor(private formBuilder: FormBuilder, private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      username: [null, Validators.required],
      password: [null, Validators.required]
    });
  }

  public login(form: any){
    let user = new User(form.value.username, form.value.password);
    console.log(user);
    if(user.password==null || user.username==null)
      this.validator=true;
    this.loginService.login(user).subscribe(response =>{
      if(response!=null){
        console.log('USO');
        this.loginService.loggedIn = true;
        window.sessionStorage.setItem("user",JSON.stringify(user));
        this.router.navigate(['home']);
      }else{
        this.validator=true;
      }
    });
   
  }

  public logout(){
    window.sessionStorage.clear();
  }
}
