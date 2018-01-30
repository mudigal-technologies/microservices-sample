import { Component, OnInit } from '@angular/core';
import {GatewayService} from '../../service/gateway/gateway.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.css']
})

export class DataComponent implements OnInit {

  objectKeys = Object.keys;
  response: DataResponse;
  error: string;

  constructor(private gatewayService: GatewayService,
              private router: Router) {
  }

  ngOnInit() {
    const currentUrl = this.router.url;
    this.getData(currentUrl.substring(1, currentUrl.length));
    console.log('Current URL: ' + currentUrl);
  }

  getData(service) {
    this.gatewayService.getData(service).subscribe(
      data => {
        console.log(data);
        this.response = data;
      },
      error => {
        this.error =  service + ' is not up. ' +
          'Please try after sometime. <br/>' + error.message;
      }
    );
  }

}

export interface DataResponse {
  originalName: string;
  originalValue: string;
  remainingNameValuePair: any[];
}
