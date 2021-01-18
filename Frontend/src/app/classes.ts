
export class RegisterEmployee{
    firstName:string;
    lastName:string;
    email:string;
    mobileNo:string;
    designation:string;
    projectId:number;
}

export class Status{
    status:string;
    message:string;
}

export class RegisterProject{
    projectName:string;
    applicationName:string;
    projectLocation:string;
    client:string;
}

export class UpdateProject{
    projectName:string;
    clientName:string;
    applicationName:string;
}

export class Projects{
    projectId:number;
    projectName:string;
    applicationName:string;
    projectLocation:string;
    client:string;
    status:string;
    sprint:string;
    employees:Employees;
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