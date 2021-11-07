import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Modules } from '../model/modules';
import { ModulesregistrationService } from '../service/modulesregistration.service';


@Component({
  selector: 'app-module-registration',
  templateUrl: './module-registration.component.html',
  styleUrls: ['./module-registration.component.css']
})
export class ModuleRegistrationComponent implements OnInit {

 

  ngOnInit(): void {
  }
 
  modsList: any;
  modulesList: Modules[] = [];
  loading: boolean = false;
  constructor(private moduleRegistrationService: ModulesregistrationService, private ref: ChangeDetectorRef,private router: Router) {
  this.loading=false;
  this.moduleRegistrationService.getModules()
  .subscribe(data => {
    console.log(data)
  this.modsList = data;
  this.modulesList = this.modsList;
  console.log(data)
  this.loading=false;
  }, (error => {
  console.log(error)
  this.loading=true;
  return null;
  }), () => {
  this.loading = false;
  });
  }
  logout(){
    localStorage.removeItem('user');
    this.router.navigateByUrl("/login");
  }   
  }