import { TestBed } from '@angular/core/testing';

import { ModuleService } from './module.service';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';

describe('ModuleService', () => {
  let service: ModuleService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [

        RouterTestingModule

      ],

      providers:[ModuleService,HttpClient,HttpHandler] 
    });
    service = TestBed.inject(ModuleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
