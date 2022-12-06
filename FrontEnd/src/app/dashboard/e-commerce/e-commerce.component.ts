import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-e-commerce',
  templateUrl: './e-commerce.component.html',
  styleUrls: ['./e-commerce.component.scss']
})
export class ECommerceComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $.getScript("./assets/js/e-commerce-dashboard.js")
  }

}
