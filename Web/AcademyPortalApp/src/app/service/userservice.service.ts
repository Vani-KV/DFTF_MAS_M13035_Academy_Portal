import { Injectable,SystemJsNgModuleLoader, ɵConsole  } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {

  constructor(private http:HttpClient) { }

  addUser(user: User) {
    console.log(user);
  return this.http.post<Observable<User>>('http://localhost:7070/user',user);
  }

  getbyname(email:string) {
    console.log(email);
  return this.http.get<Observable<User>>('http://localhost:7070/username?email='+email);
  }

  getpendingFacuties(role:string,status:string) {
    //console.log();
  return this.http.get<Observable<User>>('http://localhost:7070/faculty?role='+role+'&status='+status);
  }

  updateFaculty(faculty:User)
  {
    return this.http.put<Observable<User>>('http://localhost:7070/user',faculty);
  }

  getFacultyById(id:number)
  {
    return this.http.get<Observable<User>>('http://localhost:7070/user?id='+id);
  }

  deleteFacuties(id:number)
  {
    return this.http.delete<Observable<User>>('http://localhost:7070/user?id='+id);
  }
   
  getbyrole(faculty:string)
  {
    return this.http.get<Observable<User>>('http://localhost:7070/userrole?role='+faculty);
  }

  getbyfacultyname(firstname:string) {
    console.log(firstname);
  return this.http.get<Observable<User>>('http://localhost:7070/facultyname?firstname='+firstname);
  }


}
