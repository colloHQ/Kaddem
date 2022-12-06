import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-digital-marketing',
  templateUrl: './digital-marketing.component.html',
  styleUrls: ['./digital-marketing.component.scss']
})
export class DigitalMarketingComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $.getScript("./assets/js/digital-marketing.js")

  }

}
