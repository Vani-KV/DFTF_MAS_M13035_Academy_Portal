import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { LoginComponent } from './login/login.component';
import { StudentaccountComponent } from './studentaccount/studentaccount.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { FacutlylistComponent } from './facutlylist/facutlylist.component';
import { PendinglistComponent } from './pendinglist/pendinglist.component';
import { BatchlistComponent } from './batchlist/batchlist.component';
import { AddbatchComponent } from './addbatch/addbatch.component';
import { ReportComponent } from './report/report.component';
import { ModuleRegistrationComponent } from './module-registration/module-registration.component';
import { CreateNewModulesComponent } from './create-new-modules/create-new-modules.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FacultyaccountComponent } from './facultyaccount/facultyaccount.component';

const routes: Routes = [{ path: "register", component: RegisteruserComponent},
{ path: "login", component: LoginComponent},
{ path: "student", component: StudentaccountComponent},
{ path: "adminhome", component: AdminhomeComponent},
{ path: "facultylist", component: FacutlylistComponent},
{ path: "pendinglist", component: PendinglistComponent},
{ path: "batch", component: BatchlistComponent},
{path:"addbatch",component:AddbatchComponent},
{path:"report/:id",component:ReportComponent},
{path:"modulereg",component:ModuleRegistrationComponent},
{path:"create-new-modules",component:CreateNewModulesComponent},
{path:"home",component:HomeComponent},
{path:"faculty-account",component:FacultyaccountComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
