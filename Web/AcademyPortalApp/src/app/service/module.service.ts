
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Modules } from '../model/modules';
import { ModuleRegistrationComponent } from '../module-registration/module-registration.component';
@Injectable({
providedIn: 'root'
})
export class ModuleService {
 constructor(private http:HttpClient) { }
/*getModule(id:number) {
    return this.http.get<Modules[]>('http://localhost:4321/module/?id='+id);
}*/
getModules() {
    return this.http.get<Modules[]>('http://localhost:4321/modules');
}
createModules(modules:Modules) {
  console.log(modules);
    return this.http.post<Observable<Modules>>('http://localhost:4321/module',modules);
}  
getFacultyModules(facultyId:number) {
    return this.http.get<Modules[]>('http://localhost:8888/facultymodules?facultyId='+facultyId);
  }
}
