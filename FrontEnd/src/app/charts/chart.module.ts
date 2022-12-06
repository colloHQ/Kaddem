import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ChartRoutingModule } from './chart-routing.module';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChartsModule } from 'ng2-charts';
import { HighchartsChartModule } from 'highcharts-angular';

import { ApexChartComponent } from './apex-chart/apex-chart.component';
import { ChartjsComponent } from './chartjs/chartjs.component';
import { HighchartsComponent } from './highcharts/highcharts.component';


@NgModule({
  declarations: [
    ApexChartComponent, 
    ChartjsComponent, 
    HighchartsComponent
  ],
  imports: [
    CommonModule,
    ChartRoutingModule,
    NgbModule,
    ChartsModule,
    HighchartsChartModule
  ]
})
export class ChartModule { }
