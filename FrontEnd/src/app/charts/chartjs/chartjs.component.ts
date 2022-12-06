import { Component, OnInit } from '@angular/core';
import * as chartsData from '../../shared/data/chartjs';


@Component({
  selector: 'app-chartjs',
  templateUrl: './chartjs.component.html',
  styleUrls: ['./chartjs.component.scss']
})
export class ChartjsComponent implements OnInit {


  // lineChart
  public lineChartData = chartsData.lineChartData;
  public lineChartLabels = chartsData.lineChartLabels;
  public lineChartOptions = chartsData.lineChartOptions;
  public lineChartColors = chartsData.lineChartColors;
  public lineChartLegend = chartsData.lineChartLegend;
  public lineChartType = chartsData.lineChartType;
  

  // barChart
  public barChartOptions = chartsData.barChartOptions;
  public barChartLabels = chartsData.barChartLabels;
  public barChartType = chartsData.barChartType;
  public barChartLegend = chartsData.barChartLegend;
  public barChartData = chartsData.barChartData;
  public barChartColors = chartsData.barChartColors;

  
  // Pie
  public pieChartLabels = chartsData.pieChartLabels;
  public pieChartData = chartsData.pieChartData;
  public pieChartType = chartsData.pieChartType;
  public pieChartColors = chartsData.pieChartColors;
  public pieChartOptions = chartsData.pieChartOptions;

  
  // Radar
  public radarChartLabels = chartsData.radarChartLabels;
  public radarChartData = chartsData.radarChartData;
  public radarChartType = chartsData.radarChartType;
  public radarChartOptions = chartsData.radarChartOptions;

  // Polor
  public polorChartLabels = chartsData.polorChartLabels;
  public polorChartData = chartsData.polorChartData;
  public polorChartType = chartsData.polorChartType;
  public polorChartColors = chartsData.polorChartColors;
  public polorChartOptions = chartsData.polorChartOptions;


  // Doughnut
  public doughnutChartLabels = chartsData.doughnutChartLabels;
  public doughnutChartData = chartsData.doughnutChartData;
  public doughnutChartType = chartsData.doughnutChartType;
  public doughnutChartColors = chartsData.doughnutChartColors;
  public doughnutChartOptions = chartsData.doughnutChartOptions;

  
  // Horizontal Bar Chart
  public horizontalbarChartOptions = chartsData.horizontalbarChartOptions;
  public horizontalbarChartLabels = chartsData.horizontalbarChartLabels;
  public horizontalbarChartType = chartsData.horizontalbarChartType;
  public horizontalbarChartLegend = chartsData.horizontalbarChartLegend;
  public horizontalbarChartData = chartsData.horizontalbarChartData;
  public horizontalbarChartColors = chartsData.horizontalbarChartColors;
  
  // Grouped Chart
  public groupedbarChartOptions = chartsData.groupedbarChartOptions;
  public groupedbarChartLabels = chartsData.groupedbarChartLabels;
  public groupedbarChartType = chartsData.groupedbarChartType;
  public groupedbarChartLegend = chartsData.groupedbarChartLegend;
  public groupedbarChartData = chartsData.groupedbarChartData;
  public groupedbarChartColors = chartsData.groupedbarChartColors;
  
  // Mixed Chart
  public mixedbarChartOptions = chartsData.mixedbarChartOptions;
  public mixedbarChartLabels = chartsData.mixedbarChartLabels;
  public mixedbarChartType = chartsData.mixedbarChartType;
  public mixedbarChartLegend = chartsData.mixedbarChartLegend;
  public mixedbarChartData = chartsData.mixedbarChartData;
  public mixedbarChartColors = chartsData.mixedbarChartColors;

  // Bubble
  public bubbleChartData = chartsData.bubbleChartData; 
  public bubbleChartOptions = chartsData.bubbleChartOptions;
  public bubbleChartLegend = chartsData.bubbleChartLegend;
  public bubbleChartType = chartsData.bubbleChartType;


  constructor() { }

  ngOnInit(): void {
  }


  // events
  public chartClicked(e: any): void {
    //your code here
  }

  public chartHovered(e: any): void {
    //your code here
  }

  

}
