import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Report } from '../model/report';

@Injectable({
  providedIn: 'root'
})
export class ReportManagementService {

  constructor(private http:HttpClient) { }

getReports() {
    return this.http.get<Report[]>('http://localhost:1234/reports');
}

createReport(report:Report) {
  console.log(report);
    return this.http.post<Observable<Report>>('http://localhost:1234/report',report);
}  
    
}

