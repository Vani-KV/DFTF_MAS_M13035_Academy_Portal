import { Injectable ,SystemJsNgModuleLoader, ɵConsole} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Batch } from '../model/batch';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BatchService {

  constructor(private http:HttpClient) { }

  addBatch(batch: Batch) {
    console.log(batch);
  return this.http.post<Observable<Batch>>('http://localhost:4321/batch',batch);
  }

  getAllBatches()
  {
    return this.http.get<Observable<Batch>>('http://localhost:4321/batches');
  }

  getBatchById(id:number)
  {
    return this.http.get<Observable<Batch>>('http://localhost:4321/batch?id='+id);
  }
}
