
export class RegisterEmployee{
    firstName:string;
    lastName:string;
    email:string;
    mobileNo:string;
    designation:string;
}

export class Status{
    status:string;
    message:string;
}

export class RegisterTeam{
    teamName:string;
    applicationName:string;
    teamLocation:string;
    teamManagerId:string;
    client:string;
}

export class UpdateTeam{
    teamName:string;
    clientName:string;
    applicationName:string;
}

export class Teams{
    teamId:number;
    teamName:string;
    applicationName:string;
    managerId:number;
    managerName:string;
    teamLocation:string;
    client:string;
    status:string;
}

export class UpdateEmployee{
    firstName:string;
    lastName:string;
    emailId:string;
    mobNo:string;
}

export class Employees{
    empId:string;
    firstName:string;
    lastName:string;
    email: string;
    mobileNumber:string;
    designation: string;
    teamId: string;
}

export class AddTask{
    taskJiraId:string;
    taskDescription:string;
}

export class RegisterAdmin{
    username:string;
    password:string;
    fullName:string;
}

export class Credentials{
    username:string;
    password:string;
}
export class LoginStatus extends Status{
    name:string;
} 