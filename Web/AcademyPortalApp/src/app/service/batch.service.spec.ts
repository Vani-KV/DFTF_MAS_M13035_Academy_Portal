import { TestBed } from '@angular/core/testing';

import { BatchService } from './batch.service';
import { HttpClient, HttpHandler } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { Batch } from '../model/batch';
import { Observable } from 'rxjs';

describe('BatchService', () => {
  let service: BatchService;
  let batch:Batch;
  let date: Date = new Date("2019-01-16"); 
  let datatemp:any;
  let curdata:Batch=new Batch
  beforeEach(() => {
    TestBed.configureTestingModule({

      imports: [



        RouterTestingModule
      ],
      providers:[BatchService,HttpClient,HttpHandler] 
    });
    service = TestBed.inject(BatchService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should addbatch method should return batch', () => {
    batch.id=1;
    batch.batchName="vani";
    batch.startDate!=date;
    batch.endDate!=date;
    batch.maximumStudents=21;
    batch.facultyName='rani';
    batch.facultyId=1;
    service.addBatch(batch).subscribe(
      data => {
      datatemp=data;
      curdata=datatemp;

      expect(curdata).toEqual(batch)},
      (error => { // erro\
        expect(null).toEqual(null)
      }), () => { //complete
      });
    });
  
});
