import { Component, OnInit } from '@angular/core';
import * as highchartsData from '../../shared/data/analytics.highchartsData';


@Component({
  selector: 'app-analytics',
  templateUrl: './analytics.component.html',
  styleUrls: ['./analytics.component.scss']
})
export class AnalyticsComponent implements OnInit {

   
  // Chart 1
  public Highcharts1 = highchartsData.Highcharts1;
  public chartOptions1 = highchartsData.chartOptions1;

  
  // Chart 2
  public Highcharts2 = highchartsData.Highcharts2;
  public chartOptions2 = highchartsData.chartOptions2;

  // Chart 3
  public Highcharts3 = highchartsData.Highcharts3;
  public chartOptions3 = highchartsData.chartOptions3;

  constructor() { }

  ngOnInit(): void {
    $.getScript("./assets/js/dashboard-analytics.js")
    
  }

}
