import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterProject,Status } from '../classes';

@Component({
  selector: 'app-register-team',
  templateUrl: './register-team.component.html',
  styleUrls: ['./register-team.component.css']
})
export class RegisterTeamComponent implements OnInit {

  constructor(private http: HttpClient) { }
  
  projectInfo:RegisterProject = new RegisterProject();

  ngOnInit(): void {
  }

  register(form)
  {
    this.http.post<Status>('http://localhost:8086/addProject',this.projectInfo)
    .subscribe(res=>{
      alert(res.message);
    })
    form.reset();
  }
}
