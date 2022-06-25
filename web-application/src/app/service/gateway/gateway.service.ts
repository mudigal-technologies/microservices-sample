import { Injectable } from '@angular/core';
import { DataResponse } from '../../component/data/data.component';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class GatewayService {

  constructor(private httpClient: HttpClient) { }

  getData(service: string): Observable<DataResponse> {
    console.log('Service call: ' + service );
    return this.httpClient.get<DataResponse>('http://' + window.location.hostname + ':8080/' + service);
  }
}
