import { TestBed } from '@angular/core/testing';

import { ReportManagementService } from './report-management.service';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('ReportManagementService', () => {
  let service: ReportManagementService;

  beforeEach(() => {
    TestBed.configureTestingModule({

      imports: [

        RouterTestingModule

      ],

      providers:[ReportManagementService,HttpClient,HttpHandler] 
    });
    service = TestBed.inject(ReportManagementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
