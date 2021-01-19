import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Projects,Status} from '../classes';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-teams-info',
  templateUrl: './teams-info.component.html',
  styleUrls: ['./teams-info.component.css']
})
export class TeamsInfoComponent implements OnInit {

  constructor(private http: HttpClient,private router:Router,private _authService:AuthService) { }

  Projects:Projects;
  name:string;
  projectSprint:String

  ngOnInit(): void {
    this.name=sessionStorage.getItem('name');
    this.GetTeam(); 
  }
  
  setTeamId(projectId){
    sessionStorage.setItem('projectId',projectId);
    this.router.navigate(['TeamDetails']);
  }

  delete(projectId){
    this.http.delete<Status>("http://localhost:8086/deleteTeam?teamId="+projectId)
    .subscribe(
      res=>{
        if(res.status=='SUCCESS'){
          this.GetTeam();
        }
        else{
          alert(res.message);
        }
      }
    )
  }
   
  GetTeam(){
    this.http.get<any>('http://localhost:8086/getProjects')
    .subscribe(
      data=>{
        console.log(data);
        this.Projects=data;
      }
    )
  }

  logout(){
    this._authService.logout();
  }

  updateSprint(projectId){
    this.http.put<Status>("http://localhost:8086/updateSprint?projectId="+projectId+"&sprint="+this.projectSprint,{})
    .subscribe((res)=>{
      if(res.status=="SUCCESS"){
        alert(res.message);
        this.GetTeam();
      }
      else alert(res.message);
    })
  }

}
