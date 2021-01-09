import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Teams,Status } from '../classes';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-team-details',
  templateUrl: './team-details.component.html',
  styleUrls: ['./team-details.component.css']
})
export class TeamDetailsComponent implements OnInit {

  constructor(private http: HttpClient,private router:Router,
    private _authService:AuthService) { }
  
  teamId:string;
  teamDetails:Teams = new Teams();
  Employees;
  isButtonHidden=false;

  ngOnInit(): void {
    this.teamId=sessionStorage.getItem('teamId');
    this.http.get<Teams>("http://localhost:8086/getTeam/"+this.teamId)
    .subscribe(
      res=>{
        this.teamDetails=res;
      }
    )
    this.GetEmployees();
  }

  delete(empId){
    this.http.put<Status>("http://localhost:8086/removeEmployee?empId="+empId,{})
    .subscribe(res=>{
      console.log(res)
      if(res.status=='SUCCESS'){
        this.GetEmployees()
      }
      else{
        alert(res.message);
      }
    })
  }
  
  removeTeamId(){
    sessionStorage.setItem('teamId',null);
    this.router.navigate(['Teams'])
  }

  SetEmpId(empId){
    sessionStorage.setItem('empId',empId);
    this.router.navigate(['Tasks'])
  }

  GetEmployees(){
    this.http.get("http://localhost:8086/getEmployeeByTeam?teamId="+this.teamId)
    .subscribe(
      res=>{
        this.Employees=res;
      })
    }

    logout() {
      this._authService.logout();
    }
}
