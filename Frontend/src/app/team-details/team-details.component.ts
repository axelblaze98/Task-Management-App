import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Projects,Status } from '../classes';
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
  
  projectId:string;
  projectDetails:Projects = new Projects();
  isButtonHidden=false;

  ngOnInit(): void {
    this.projectId=sessionStorage.getItem('projectId');
    this.http.get<Projects>("http://localhost:8086/getProject/"+this.projectId)
    .subscribe(
      res=>{
        this.projectDetails=res;
      }
    )
  }

  delete(empId){
    this.http.delete<Status>("http://localhost:8086/removeEmployeeFromProject?empId="+empId+"&projectId="+this.projectId)
    .subscribe(res=>{
      if(res.status=="SUCCESS"){
        this.ngOnInit();
      }
      else alert(res.message);
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
    logout() {
      this._authService.logout();
    }
}
