import { Component, OnInit } from '@angular/core';
import { Batch } from '../model/batch';
import { BatchService } from '../service/batch.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-batchlist',
  templateUrl: './batchlist.component.html',
  styleUrls: ['./batchlist.component.css']
})
export class BatchlistComponent implements OnInit {

  loading: boolean = false;
  batchList: any;
  batchtemp: any;
  BatchtempList: Batch[] = [];
  batch:Batch = new Batch;
  constructor(private batchserv: BatchService, private router: Router) {
    this.batchserv.getAllBatches()
      .subscribe(data => {
        this.batchList = data;
        this.BatchtempList = this.batchList;
        console.log(this.BatchtempList);
        this.loading = false;
      }, (error => {
        console.log(error)
        this.loading = true;
        return null;
      }), () => {
        this.loading = false;
      });
  }

  ngOnInit(): void {
  }

  logout(){
    localStorage.removeItem('user');
    this.router.navigateByUrl("/login");
  }
}
