import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { AuthModule } from './auth/auth.module';
import { HomeModule } from './home/home.module';
import { LoginService } from './auth/services/login.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot(),
    AuthModule,
    HomeModule,
    BrowserAnimationsModule,
    NgbModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
