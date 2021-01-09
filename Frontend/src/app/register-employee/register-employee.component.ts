import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { RegisterEmployee,Status } from '../classes';

@Component({
  selector: 'app-register-employee',
  templateUrl: './register-employee.component.html',
  styleUrls: ['./register-employee.component.css']
})
export class RegisterEmployeeComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  empInfo:RegisterEmployee = new RegisterEmployee();

  register(){
    this.http.post<Status>("http://localhost:8086/registerEmployee",this.empInfo)
    .subscribe(res =>{
      alert(res.message);
    })
  }
}
