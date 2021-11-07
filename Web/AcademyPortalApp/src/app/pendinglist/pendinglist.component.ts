import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserserviceService } from '../service/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pendinglist',
  templateUrl: './pendinglist.component.html',
  styleUrls: ['./pendinglist.component.css']
})
export class PendinglistComponent implements OnInit {

  loading: boolean = false;
  facultyList: any;
  emptemp: any;
  tempList: User[] = [];
  user: User = new User;
  faculty:User=new User;
  role: string = 'faculty';
  status: string = 'inactive';
  currdata: any;
  error:any;
  constructor(private facultylistser: UserserviceService, private router: Router) {
    this.facultylistser.getpendingFacuties(this.role, this.status)
      .subscribe(data => {
        this.facultyList = data;
        this.tempList = this.facultyList;
        console.log(this.tempList);
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
  
   onclickapprove(id:any)
  {
    this.facultylistser.getFacultyById(id).subscribe(data => { 
      this.currdata = data;
      this.faculty = this.currdata;
      this.faculty.status='active';
      this.facultylistser.updateFaculty(this.faculty)
      .subscribe(data =>{
        alert("Faculty approved successfully");
      },(error => {
        console.log(error)
        this.loading = true;
        return null;
      }), () => {
        this.loading = false;
      });

      
    }, (error => { // error
      alert("Error in fetching details");
      console.log(error)
      return null;
    }), () => { //complete
    });

  }


  onclickreject(id:number)
  {
    this.facultylistser.deleteFacuties(id)
    .subscribe(data =>{
      alert("Faculty rejected successfully");
    },(error => {
      console.log(error)
      alert("error in delete")
      this.loading = true;
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
