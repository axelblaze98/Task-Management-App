import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Teams,Status} from '../classes';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-teams-info',
  templateUrl: './teams-info.component.html',
  styleUrls: ['./teams-info.component.css']
})
export class TeamsInfoComponent implements OnInit {

  constructor(private http: HttpClient,private router:Router,private _authService:AuthService) { }

  Teams:Teams;
  name:string;

  ngOnInit(): void {
    this.name=sessionStorage.getItem('name');
    this.GetTeam(); 
  }
  
  setTeamId(teamId){
    sessionStorage.setItem('teamId',teamId);
    this.router.navigate(['TeamDetails']);
  }

  delete(teamId){
    this.http.delete<Status>("http://localhost:8086/deleteTeam?teamId="+teamId)
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
    this.http.get<any>('http://localhost:8086/getTeams')
    .subscribe(
      data=>{
        this.Teams=data;
      }
    )
  }

  logout(){
    this._authService.logout();
  }

}
