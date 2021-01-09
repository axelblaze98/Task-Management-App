import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AddTask } from '../classes';

@Component({
  selector: 'app-register-task',
  templateUrl: './register-task.component.html',
  styleUrls: ['./register-task.component.css']
})
export class RegisterTaskComponent implements OnInit {

  constructor(private http: HttpClient) { }

  empId:number;
  taskDetails:AddTask = new AddTask();

  ngOnInit(): void {
    this.empId=history.state.empId;
  }

  register(){
    this.http.post<any>("http://localhost:8086/addTask?empId="+this.empId,this.taskDetails)
    .subscribe((res)=>{
      alert(res.message);
    })
  }

}
