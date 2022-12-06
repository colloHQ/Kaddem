import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-apex-chart',
  templateUrl: './apex-chart.component.html',
  styleUrls: ['./apex-chart.component.scss']
})
export class ApexChartComponent implements OnInit {



  constructor() { }

  ngOnInit(): void {
    $.getScript('./assets/js/apex-custom.js');
  }

}
