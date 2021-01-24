import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { RegisterEmployee,Projects,Status } from '../classes';

@Component({
  selector: 'app-register-employee',
  templateUrl: './register-employee.component.html',
  styleUrls: ['./register-employee.component.css']
})
export class RegisterEmployeeComponent implements OnInit {

  projects;
  empInfo:RegisterEmployee = new RegisterEmployee();
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.http.get<Projects>("http://localhost:8086/getProjects")
    .subscribe(res => {
      this.projects= res;
    })
  }



  register(form){
    this.http.post<Status>("http://localhost:8086/registerEmployee",this.empInfo)
    .subscribe(res =>{
      alert(res.message);
    })
    form.reset();
  }
}
