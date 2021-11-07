import { TestBed } from '@angular/core/testing';

import { UserserviceService } from './userservice.service';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('UserserviceService', () => {
  let service: UserserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({

      imports: [

        RouterTestingModule

      ],

      providers:[UserserviceService,HttpClient,HttpHandler] 
    });
    service = TestBed.inject(UserserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
