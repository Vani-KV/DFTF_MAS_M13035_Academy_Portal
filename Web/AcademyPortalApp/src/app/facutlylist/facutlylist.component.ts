import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../service/userservice.service';
import { Router } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-facutlylist',
  templateUrl: './facutlylist.component.html',
  styleUrls: ['./facutlylist.component.css']
})
export class FacutlylistComponent implements OnInit {
  loading: boolean = false;
  facultyList: any;
  emptemp: any;
  tempList: User[] = [];
  user: User = new User;
  role: string = 'faculty';
  status: string = 'active';
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
  logout(){
    localStorage.removeItem('user');
    this.router.navigateByUrl("/login");
  }

  ngOnInit(): void {
  }

  
}
