import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MainpageComponent } from './mainpage/mainpage.component';
import { RegisterEmployeeComponent } from './register-employee/register-employee.component';
import { RegisterTeamComponent } from './register-team/register-team.component';
import { RegisterTaskComponent } from './register-task/register-task.component';
import { TeamsInfoComponent } from './teams-info/teams-info.component';
import { EditTeamDetailsComponent } from './edit-team-details/edit-team-details.component';
import { TeamDetailsComponent } from './team-details/team-details.component';
import { UpdateManagerComponent } from './update-manager/update-manager.component';
import { EditEmployeesComponent } from './edit-employees/edit-employees.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { AddTeamMemberComponent } from './add-team-member/add-team-member.component';
import { RegisterAdminComponent } from './register-admin/register-admin.component';
import { AuthGuard } from './auth.guard';



const routes: Routes = [
  {path:'',component: MainpageComponent},
  {path:'RegisterEmployee',component: RegisterEmployeeComponent,canActivate:[AuthGuard]},
  {path:'RegisterTeam',component: RegisterTeamComponent,canActivate:[AuthGuard]},
  {path:'RegisterTask',component: RegisterTaskComponent,canActivate:[AuthGuard]},
  {path:'Teams',component: TeamsInfoComponent,canActivate:[AuthGuard]},
  {path:'EditTeams',component:EditTeamDetailsComponent,canActivate:[AuthGuard]},
  {path:'TeamDetails',component:TeamDetailsComponent,canActivate:[AuthGuard]},
  {path:'UpdateManager',component:UpdateManagerComponent,canActivate:[AuthGuard]},
  {path:'EditEmployee',component:EditEmployeesComponent,canActivate:[AuthGuard]},
  {path:'Tasks',component:EmployeeDetailsComponent,canActivate:[AuthGuard]},
  {path:'AddTeamMember',component:AddTeamMemberComponent,canActivate:[AuthGuard]},
  {path:'RegisterAdmin',component:RegisterAdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents=[MainpageComponent,RegisterEmployeeComponent,RegisterTeamComponent,RegisterTaskComponent,TeamsInfoComponent,EditTeamDetailsComponent,TeamDetailsComponent,UpdateManagerComponent,
EditEmployeesComponent,EmployeeDetailsComponent,AddTeamMemberComponent,RegisterAdminComponent];
