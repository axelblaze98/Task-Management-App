import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { CanActivate, Router} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private Router: Router,private _authService: AuthService){}
  canActivate():boolean{
    if(this._authService.LoggedIn()){
      return true;
    }
    else{
      this.Router.navigate(['/']);
    }
  }
  
}
