import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { LoginComponent } from './login/login.component';
import { FacultyaccountComponent } from './facultyaccount/facultyaccount.component';
import { StudentaccountComponent } from './studentaccount/studentaccount.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { FacutlylistComponent } from './facutlylist/facutlylist.component';
import { PendinglistComponent } from './pendinglist/pendinglist.component';
import { BatchlistComponent } from './batchlist/batchlist.component';
import { AddbatchComponent } from './addbatch/addbatch.component';
import { ReportComponent } from './report/report.component';
import { ModuleRegistrationComponent } from './module-registration/module-registration.component';
import { CreateNewModulesComponent } from './create-new-modules/create-new-modules.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisteruserComponent,
    LoginComponent,
    FacultyaccountComponent,
    StudentaccountComponent,
    AdminhomeComponent,
    FacutlylistComponent,
    PendinglistComponent,
    BatchlistComponent,
    AddbatchComponent,
    ReportComponent,
    ModuleRegistrationComponent,
    CreateNewModulesComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
