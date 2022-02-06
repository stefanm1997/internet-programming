import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class ServiceGuard implements CanActivate {
  // canActivate(
  //   route: ActivatedRouteSnapshot,
  //   state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
  //   return true;
  // }
  constructor(private loginService: LoginService,
    private router: Router) { }

  canActivate(): boolean {
    let user = JSON.parse(window.sessionStorage.getItem("user"));
    if (user!=null) {
      return true;
    } else {
      this.router.navigate(['login']);
      return false;
    }
  }
  
}
