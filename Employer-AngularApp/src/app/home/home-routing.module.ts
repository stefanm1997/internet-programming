import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServiceGuard } from '../auth/services/service.guard';
import { HomeComponent } from './home/home.component';
import { MenuFlightComponent } from './menu-flight/menu-flight.component';
import { MenuMessageComponent } from './menu-message/menu-message.component';
import { MenuReservationComponent } from './menu-reservation/menu-reservation.component';
import { MenuComponent } from './menu/menu.component';

const routes: Routes = [
  {  
    path: '',
    component: MenuComponent,
    children: [
    {
      path: '',
      component: HomeComponent
    },
    {
      path: 'home-flight',
      component:  MenuFlightComponent,
      canActivate: [ServiceGuard]
    },
    {
      path: 'home-reservation',
      component:  MenuReservationComponent,
      canActivate: [ServiceGuard]
    },
    {
      path: 'home-message',
      component:  MenuMessageComponent,
      canActivate: [ServiceGuard]
    }
  ]
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
