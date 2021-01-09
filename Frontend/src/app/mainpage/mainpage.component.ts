import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Credentials,LoginStatus } from '../classes';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent implements OnInit {

  constructor(private http: HttpClient,private router:Router) { }

  credential:Credentials = new Credentials();
  ngOnInit(): void {
  }

  login(){
    this.http.post<LoginStatus>("http://localhost:8086/login",this.credential)
    .subscribe(res=>{
      if(res.status=='SUCCESS'){
        sessionStorage.setItem("name",res.name);
        this.router.navigate(['Teams']);
      }
      else alert(res.message);
    })
  }
}
