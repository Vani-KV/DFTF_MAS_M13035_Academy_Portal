import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../service/userservice.service';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { ModulesregistrationService } from '../service/modulesregistration.service';
import { Modules } from '../model/modules';
import { ModuleRegistrationService } from '../service/modules-registration.service';

@Component({
selector: 'app-facultyaccount',
templateUrl: './facultyaccount.component.html',
styleUrls: ['./facultyaccount.component.css']
})
export class FacultyaccountComponent implements OnInit {
tempdata: any;
faculty:User=new User();
loading: boolean=false;
tempfaculty:any;
facultyfield:any;
tempmodule:any;
modules:Modules[]=[];
constructor(private facultyaccount: UserserviceService,private moduleserv:ModuleRegistrationService, private router: Router) {

 this.tempfaculty=localStorage.getItem("userlocal");
this.facultyfield=JSON.parse(this.tempfaculty);
//console.log(this.facultyfield);
this.facultyaccount.getbyname(this.facultyfield.email)
.subscribe(data => {
this.tempdata = data;
this.faculty=this.tempdata;
//console.log(this.faculty);
this.loading = false;
}, (error => {
console.log(error)
this.loading = true;
return null;
}), () => {
this.loading = false;
});

this.moduleserv.getFacultyModules(this.facultyfield.id)
.subscribe(data => {
this.tempmodule = data;
this.modules=this.tempmodule;
console.log(this.modules);
this.loading = false;
}, (error => {
console.log(error)
this.loading = true;
return null;
}), () => {
this.loading = false;
});

}

 ngOnInit(): void {

}
logout(){
  localStorage.removeItem('user');
  this.router.navigateByUrl("/home");
}

}