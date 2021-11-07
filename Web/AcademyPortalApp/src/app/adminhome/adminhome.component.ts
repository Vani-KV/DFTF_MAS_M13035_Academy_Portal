import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { UserserviceService } from '../service/userservice.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {
  loading: boolean = false;
  facultyList: any;
  emptemp: any;
  tempList: User[] = [];
  user: User = new User;
  role: string = 'faculty';
  status: string = 'inactive';
  constructor(private facultylistser: UserserviceService, private router: Router) {
  }
  logout(){
    localStorage.removeItem('user');
    this.router.navigateByUrl("/home");
  }

  ngOnInit(): void {
  }

}
