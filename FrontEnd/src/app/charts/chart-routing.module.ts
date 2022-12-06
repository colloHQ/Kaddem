import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApexChartComponent } from './apex-chart/apex-chart.component';
import { ChartjsComponent } from './chartjs/chartjs.component';
import { HighchartsComponent } from './highcharts/highcharts.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'apex-chart',
        component: ApexChartComponent,
        data: {
          title: 'Apex Chart'
        }
      },
      {
        path: 'chartjs',
        component: ChartjsComponent,
        data: {
          title: 'Chart Js'
        }
      },
      {
        path: 'highcharts',
        component: HighchartsComponent,
        data: {
          title: 'Highcharts'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ChartRoutingModule { }
