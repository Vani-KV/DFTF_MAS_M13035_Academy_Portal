import { Component, OnInit } from '@angular/core';
import { Batch } from '../model/batch';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { BatchService } from '../service/batch.service';
import { Router } from '@angular/router';
import { UserserviceService } from '../service/userservice.service';
import { User } from '../model/user';

@Component({
  selector: 'app-addbatch',
  templateUrl: './addbatch.component.html',
  styleUrls: ['./addbatch.component.css']
})
export class AddbatchComponent implements OnInit {

  message!: string;
  currdata: any;
  curruser: Batch = new Batch;
  tempdata: any;
  facultylist: User[] = [];

  facultynames: string[] = [];
  tempfaculty: any;

  batchadded: any;
  batchAdd: Batch = new Batch;
  newbatch:Batch=new Batch;
  currfaculty: User = new User;
  batch: Batch = new Batch();
  addbatchForm = new FormGroup({
    batchName: new FormControl('', [Validators.required]),
    startDate: new FormControl('', [Validators.required]),
    endDate: new FormControl('', [Validators.required]),
    maximumStudents: new FormControl('', [Validators.required]),
    facultyName:new FormControl('', [Validators.required])
  })


  constructor(private batchserv: BatchService, private router: Router, private userserv: UserserviceService) {

    this.userserv.getpendingFacuties('faculty', 'active').subscribe(data => {
      this.tempdata = data;
      this.facultylist = this.tempdata;
      for (let user of this.facultylist) {
        this.facultynames.push(user.firstname);
      }


    }, (error => { // error
      console.log(error)
      return null;
    }), () => { //complete
    });
  }


  onSubmit() { //form validation using if...
    if (!this.addbatchForm.invalid) {
      console.log(this.addbatchForm.getRawValue().facultyName);
      this.userserv.getbyfacultyname(this.addbatchForm.getRawValue().facultyName).subscribe(data => {
        this.tempfaculty = data;
        this.currfaculty = this.tempfaculty;


        this.newbatch.batchName=this.addbatchForm.getRawValue().batchName;
        this.newbatch.startDate=this.addbatchForm.getRawValue().startDate;
        this.newbatch.endDate=this.addbatchForm.getRawValue().endDate;
        this.newbatch.maximumStudents=this.addbatchForm.getRawValue().maximumStudents;
        this.newbatch.facultyName=this.addbatchForm.getRawValue().facultyName;
        this.newbatch.facultyId=this.currfaculty.id;
        
        if (this.currfaculty.batchId === 0) {
          
          this.batchserv.addBatch(this.newbatch).subscribe(data => {
            alert(" Batch successfully created.");
            this.batchadded = data;
            this.batchAdd = this.batchadded;
            this.currfaculty.batchId = this.batchAdd.id
            this.userserv.updateFaculty(this.currfaculty).subscribe(data =>{

            },(error => { // error
              alert("Error in creating user details.");
              console.log(error)
              return null;
            }), () => { //complete
            });
            this.router.navigateByUrl("/batch"); 
          }, (error => { // error
            alert("Error in creating user details.");
            console.log(error)
            return null;
          }), () => { //complete
          });

        }
        else {
          alert("Faculty is already engaged please select another faculty");
        }

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
