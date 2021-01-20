import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employees,Status } from '../classes';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {

  constructor(private http:HttpClient,private router:Router,private _authService:AuthService) { }

  empId:string;
  empInfo:Employees = new Employees();
  Tasks;
  taskStatus:string;
  statusBtn:boolean=false;

  ngOnInit(): void {
    this.empId=sessionStorage.getItem('empId');
    this.http.get<Employees>("http://localhost:8086/employee/"+this.empId)
    .subscribe(
      (res)=>{
        this.empInfo=res;
      })
    this.GetTask();
  }

  updateTaskStatus(taskId){
    if(this.statusBtn){
      if(this.taskStatus==undefined){
        alert("Select Task Status");
      }
      else{
        this.http.put<Status>("http://localhost:8086/updateTaskStatus?taskId="+taskId+"&updatedStatus="+this.taskStatus,{})
        .subscribe((res)=>{
          if(res.status=='SUCCESS'){
            alert(res.message)
            this.GetTask();
          }
          else alert(res.message);
          this.statusBtn =!this.statusBtn;
        })
    }
}
  else this.statusBtn=!this.statusBtn;
  }

  GetTask(){
    this.http.get<any>("http://localhost:8086/getEmployeeTasks?empId="+this.empId).
    subscribe(
      res=>{
        this.Tasks=res;
      }
    )
  }

  RemoveEmpId(){
    sessionStorage.setItem('empId',null);
    this.router.navigate(['TeamDetails']);
  }

  logout(){
    this._authService.logout();
  }

}
