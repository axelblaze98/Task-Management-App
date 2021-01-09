import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterTeam,Status } from '../classes';

@Component({
  selector: 'app-register-team',
  templateUrl: './register-team.component.html',
  styleUrls: ['./register-team.component.css']
})
export class RegisterTeamComponent implements OnInit {

  constructor(private http: HttpClient) { }
  
  BenchedManagers;
  teamInfo:RegisterTeam = new RegisterTeam();

  ngOnInit(): void {
    this.http.get<any>('http://localhost:8086/getBenchedManagers')
    .subscribe(
      data=>{
        console.log(data)
        this.BenchedManagers= data;
      }
    )
  }

  register()
  {
    this.http.post<Status>('http://localhost:8086/addTeam',this.teamInfo)
    .subscribe(res=>{
      alert(res.message);
    })
  }
}
