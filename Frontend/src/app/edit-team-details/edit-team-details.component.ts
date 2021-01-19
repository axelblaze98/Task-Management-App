import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Status, UpdateProject} from '../classes';

@Component({
  selector: 'app-edit-team-details',
  templateUrl: './edit-team-details.component.html',
  styleUrls: ['./edit-team-details.component.css']
})
export class EditTeamDetailsComponent implements OnInit {

  constructor(private http:HttpClient) { }

  //All Declarations
  projectId: number;
  updateProjectInfo:UpdateProject = new UpdateProject();

  ngOnInit(): void {
    this.projectId=history.state.projectId;
    this.http.get<any>("http://localhost:8086/getProject/"+this.projectId)
    .subscribe(
      res=>{
        this.updateProjectInfo.projectName=res.projectName;
        this.updateProjectInfo.applicationName=res.applicationName;
        this.updateProjectInfo.clientName=res.client;
      }
    )
  }

  update(){
    this.http.put<Status>("http://localhost:8086/updateProjectDetails?projectId="+this.projectId,this.updateProjectInfo)
    .subscribe(res=>{
      alert(res.message);
    })
  }
}
