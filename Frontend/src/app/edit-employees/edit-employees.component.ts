import { UpdateEmployee,Status } from './../classes';
import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-edit-employees',
  templateUrl: './edit-employees.component.html',
  styleUrls: ['./edit-employees.component.css']
})
export class EditEmployeesComponent implements OnInit {

  constructor(private http: HttpClient) { }

  empDetails:UpdateEmployee = new UpdateEmployee();
  empId:number;

  ngOnInit(): void {
    this.empId=history.state.empId;
    this.http.get<any>("http://localhost:8086/employee/"+this.empId)
    .subscribe((res)=>{
      this.empDetails.firstName=res.firstName;
      this.empDetails.lastName=res.lastName;
      this.empDetails.mobNo=res.mobileNumber;
      this.empDetails.emailId=res.email;
    })
  }

  UpdateEmployee(){
    this.http.put<Status>("http://localhost:8086/updateEmployee?empId="+this.empId,this.empDetails).
    subscribe(
      res=>{
        alert(res.message);
      }
    )
  }

}
