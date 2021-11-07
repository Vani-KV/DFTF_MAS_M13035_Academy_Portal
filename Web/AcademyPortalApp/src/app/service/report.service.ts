import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Report } from '../model/report';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class ReportService {
  credit:any;
  constructor(private http:HttpClient) { }
getReports() {
    return this.http.get<Report[]>('http://localhost:4444/reports');
}
createReport(report:Report) {
  console.log(report);
    return this.http.post<Observable<Report>>('http://localhost:4444/report',report);
}  

calculatecredit(reporttemp:Report):any
{
    this.credit=reporttemp.implementation+reporttemp.interaction+reporttemp.participation+reporttemp.understanding;
    this.credit=this.credit/4;
    return this.credit;
}
    
}