import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Status } from '../classes';

@Component({
  selector: 'app-add-team-member',
  templateUrl: './add-team-member.component.html',
  styleUrls: ['./add-team-member.component.css']
})
export class AddTeamMemberComponent implements OnInit {

  constructor(private http: HttpClient) { }

  benchedEmployees;
  employeeId:number;
  teamId:string;

  ngOnInit(): void {
    this.teamId=sessionStorage.getItem('teamId');
    this.http.get<any>("http://localhost:8086/getBenchedEmployees")
    .subscribe(
      res=>{
        console.log(res);
        this.benchedEmployees=res;
      }
    )
  }

  update(){
    this.http.put<Status>("http://localhost:8086/addEmployee?teamId="+this.teamId+"&empId="+this.employeeId,{})
    .subscribe(
      res=>{
        alert(res.message);
      }
    )
  }

}
