import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { UserserviceService } from '../service/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registeruser',
  templateUrl: './registeruser.component.html',
  styleUrls: ['./registeruser.component.css']
})
export class RegisteruserComponent implements OnInit {
  message!: string;
  currdata: any;
  curruser:User=new User;
  roleList: any = ['student', 'faculty', 'Admin']  
  
  user:User=new User();
  registerForm=new FormGroup({
    firstname: new FormControl('',  [Validators.required]),
    lastname: new FormControl('',  [Validators.required]),
   email: new FormControl('', [Validators.required, Validators.email]),
   role:new FormControl('', [Validators.required]),
   gender: new FormControl('',  [Validators.required]),
   age:new FormControl('',  [Validators.required,Validators.min(18)]),
   password:new FormControl('',[Validators.required,Validators.pattern(/^(?=\D*\d)(?=[^a-z]*[a-z])(?=[^A-Z]*[A-Z]).{8,30}$/)])
 })
  

  constructor(private userserv:UserserviceService,private router: Router) { }

  onSubmit(){ //form validation using if...
    if (!this.registerForm.invalid) {
      this.userserv.addUser(this.registerForm.getRawValue()).subscribe(data => {
        alert("user is successfully created.");
        console.log(this.curruser.role)
        
          this.router.navigateByUrl("/login");
      }, (error => { // error
        alert("Error in creating user details.");
        console.log(error)
        return null;
      }), () => { //complete
      });
    } 
  }

  ngOnInit(): void {
  }

}
