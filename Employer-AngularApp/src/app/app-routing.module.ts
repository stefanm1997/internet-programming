import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './auth/login/login.component';
import { ServiceGuard } from './auth/services/service.guard';

const routes: Routes = [

  {
    path: 'login',
    loadChildren: () => import('./auth/auth.module').then(mod => mod.AuthModule)
    
  },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(mod => mod.HomeModule),
    canActivate: [ServiceGuard]
  },
  {
    path:'',
    redirectTo: '/login',
    pathMatch: 'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
