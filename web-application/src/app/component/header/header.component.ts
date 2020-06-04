import { Component, OnInit } from '@angular/core';
import { faCubes } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

    faCubes = faCubes;
  
  constructor() { }

  ngOnInit() {
  }

}
