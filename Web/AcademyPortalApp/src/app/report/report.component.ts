import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Report } from '../model/report';
import { ReportService } from '../service/report.service';
import { BatchService } from '../service/batch.service';
import { Batch } from '../model/batch';
import { UserserviceService } from '../service/userservice.service';
import { User } from '../model/user';
@Component({
  selector: 'app-report-management',
  templateUrl: './report.component.html',
  styleUrls: ['./report.component.css']
})
export class ReportComponent implements OnInit {
  message!: string;
  report: Report=new Report;
  batchId:any;
  batch:Batch = new Batch;
  currdata:any;
  facultyId:any;
  currreport:any;
  reporttemp:Report=new Report;
  reportId:any;
  credit:any;
  currfaculty:any;
  faculty:User=new User;
  loading: boolean=false;
  reportForm=new FormGroup({
    participation: new FormControl('',  [Validators.required]),
   interaction: new FormControl('',  [Validators.required]),
   understanding: new FormControl('',  [Validators.required]),
   implementation: new FormControl('',  [Validators.required]),
 })
  
  
  constructor(private reportManagementService:ReportService,private activatedRoute: ActivatedRoute,private router:Router,private batchserv: BatchService,private userserv:UserserviceService) {
    this.batchId=activatedRoute.snapshot.paramMap.get("id");
   console.log(this.batchId)
   }
  onSubmit(){ //form validation using if...
    if (!this.reportForm.invalid)
    {

      this.report.batchId=this.batchId;
      this.report.implementation=this.reportForm.getRawValue().implementation;
      this.report.interaction=this.reportForm.getRawValue().interaction;
      this.report.participation=this.reportForm.getRawValue().participation;
      this.report.understanding=this.reportForm.getRawValue().understanding;
      console.log(this.report);
      
      this.reportManagementService.createReport(this.report).subscribe(data => {
        this.currreport=data;
        this.reporttemp=this.currreport;
        this.reportId=this.reporttemp.id
        alert("report is successfully submitted.");


        this.batchserv.getBatchById(this.batchId).subscribe(data => {
          this.currdata=data;
          this.batch=this.currdata;
          this.facultyId=this.batch.facultyId;
          this.credit=this.reportManagementService.calculatecredit(this.reporttemp); 
         
          this.userserv.getFacultyById(this.facultyId)
          .subscribe(data => {
            this.currfaculty = data;
            this.faculty = this.currfaculty;
           this.faculty.credit=this.credit;
           this.userserv.updateFaculty(this.faculty).subscribe(data => {
            alert("Faculty credit added successfully.");
            //console.log(this.curruser.role)
            
              this.router.navigateByUrl("/batch");
          }, (error => { // error
            alert("Error in creating user details.");
            console.log(error)
            return null;
          }), () => { //complete
          });

            //console.log(this.tempList);
            this.loading = false;
          }, (error => {
            console.log(error)
            this.loading = true;
            return null;
          }), () => {
            this.loading = false;
          }); 

        }, (error => {
          console.log(error)
          this.loading = true;
          return null;
        }), () => {
          this.loading = false;
        }); 






        console.log(this.report)
      }, (error => { // error
        alert("Error in creating report details.");
        console.log(error)
        return null;
      }), () => { //complete
      });



  







  }
}

  ngOnInit(): void {
  }

}
