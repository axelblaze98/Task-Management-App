import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Status } from '../classes';

@Component({
  selector: 'app-update-manager',
  templateUrl: './update-manager.component.html',
  styleUrls: ['./update-manager.component.css']
})
export class UpdateManagerComponent implements OnInit {

  constructor(private http: HttpClient,private router: Router) { }

  BenchedManagers;
  empId:number;
  teamId;

  ngOnInit(): void {
    this.teamId=history.state.teamId;
    this.http.get<any>('http://localhost:8086/getBenchedManagers')
    .subscribe(
      data=>{
        this.BenchedManagers= data;
      }
    )
  }

  update(){
    this.http.put<Status>("http://localhost:8086/updateManager?managerId="+this.empId+"&teamId="+this.teamId,{})
    .subscribe(res=>{
      alert(res.message);
    })
  }
}
