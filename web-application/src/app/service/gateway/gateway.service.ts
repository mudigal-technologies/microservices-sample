import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { DataResponse } from '../../component/data/data.component';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class GatewayService {

  constructor(private httpClient: HttpClient) { }

  getData(service: string): Observable<DataResponse> {
    console.log('Service call: ' + service );
    return this.httpClient.get<DataResponse>('http://' + window.location.hostname + ':8080/' + service);
  }
}
