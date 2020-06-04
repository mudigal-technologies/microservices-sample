import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

declare var $: any;

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor() { }

  one() {
    $('#service-one').addClass('active');
    $('#service-two').removeClass('active');
  }

  two() {
    $('#service-one').removeClass('active');
    $('#service-two').addClass('active');
  }

}
