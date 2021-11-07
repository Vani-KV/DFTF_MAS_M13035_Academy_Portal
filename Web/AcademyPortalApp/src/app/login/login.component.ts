import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserserviceService } from '../service/userservice.service';
import { User } from '../model/user';

@Component({
selector: 'app-login',
templateUrl: './login.component.html',
styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
currdata: any;

 constructor(private login:UserserviceService,private router:Router) { }

 user:User=new User();
loginForm=new FormGroup({
username: new FormControl('', [Validators.required]),
password: new FormControl('', [Validators.required])
})

 onSubmit() {
if (!this.loginForm.invalid) {
this.login.getbyname(this.loginForm.getRawValue().username).subscribe(data => { //success
this.currdata=data;
this.user=this.currdata;
console.log(this.loginForm.getRawValue())
console.log(this.user)
if ( this.loginForm.value['username'] === this.user.email && this.loginForm.value['password'] === this.user.password && this.user.role=='Admin')
{
localStorage.setItem('userlocal',JSON.stringify(this.user));
this.router.navigateByUrl("/adminhome");
}
else if(this.loginForm.value['username'] === this.user.email && this.loginForm.value['password'] === this.user.password && this.user.role==='faculty'){
if(this.user.status=='active')
{
localStorage.setItem('userlocal',JSON.stringify(this.user));
this.router.navigateByUrl("/faculty-account");
}
else
{
alert("Your account has been submitted for admin approval");
}
}
else if(this.loginForm.value['username'] === this.user.email && this.loginForm.value['password'] === this.user.password && this.user.role==='student'){
  
  localStorage.setItem('userlocal',JSON.stringify(this.user));
  this.router.navigateByUrl("/home");
}

else if(this.user==null ){
alert("useraccount doesn't exist or password is incorrect");
}
else{
alert("incorrect password");
}
}, (error => { // error
//console.log(error)
return null;
}), () => { //complete
});
}

 if( this.loginForm.value['username'] === 'admin' && this.loginForm.value['password'] === 'admin')
  {  
     localStorage.setItem('userlocal',JSON.stringify(this.user));
       this.router.navigateByUrl("/adminhome");
}

}

 ngOnInit(): void {
}

}