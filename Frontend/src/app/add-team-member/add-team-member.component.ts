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

  employees;
  employeeId:number;
  projectId:string;

  ngOnInit(): void {
    this.projectId=sessionStorage.getItem('projectId');
    this.http.get<any>("http://localhost:8086/getEmployees?projectId="+this.projectId)
    .subscribe(
      res=>{
        this.employees=res;
      }
    )
  }

  update(){
    if(this.employeeId==undefined){
      alert("Select the Employee to be added")
    }
    else{
    this.http.put<Status>("http://localhost:8086/addEmployeeToProject?empId="+this.employeeId+"&projectId="+this.projectId,{})
    .subscribe(
      res=>{
        alert(res.message);
        this.ngOnInit();
      }
    )
  }
}

}
