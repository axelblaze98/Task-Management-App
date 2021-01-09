import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { UpdateTeam,Status} from '../classes';

@Component({
  selector: 'app-edit-team-details',
  templateUrl: './edit-team-details.component.html',
  styleUrls: ['./edit-team-details.component.css']
})
export class EditTeamDetailsComponent implements OnInit {

  constructor(private http:HttpClient) { }

  //All Declarations
  teamId: number;
  updateTeamInfo:UpdateTeam = new UpdateTeam();

  ngOnInit(): void {
    this.teamId=history.state.teamId;
    console.log(this.teamId);
    this.http.get<any>("http://localhost:8086/getTeam/"+this.teamId)
    .subscribe(
      res=>{
        this.updateTeamInfo.teamName=res.teamName;
        this.updateTeamInfo.applicationName=res.applicationName;
        this.updateTeamInfo.clientName=res.client;
      }
    )
  }

  update(){
    this.http.put<Status>("http://localhost:8086/updateTeamDetails?teamId="+this.teamId,this.updateTeamInfo)
    .subscribe(res=>{
      alert(res.message);
    })
  }
}
