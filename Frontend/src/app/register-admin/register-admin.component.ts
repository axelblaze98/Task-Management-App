import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RegisterAdmin,Status } from '../classes';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.css']
})
export class RegisterAdminComponent implements OnInit {

  constructor(private http: HttpClient) { }

  adminInfo:RegisterAdmin = new RegisterAdmin();
  ngOnInit(): void {
  }

  register(){
    this.http.post<Status>("http://localhost:8086/register",this.adminInfo)
    .subscribe((res)=>{
      alert(res.message)
    })
  }

}
