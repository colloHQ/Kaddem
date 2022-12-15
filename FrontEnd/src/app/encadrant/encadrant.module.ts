import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EncadrantRoutingModule } from './encadrant-routing.module';
import { EncadrantComponent } from './encadrant.component';
import { HomeComponent } from './home/home.component';
import { CreateComponent } from './create/create.component';
import { DetailsComponent } from './details/details.component';
import { UpdateComponent } from './update/update.component';
import { FormsModule } from '@angular/forms';
import { AnalyticsComponent } from './analytics/analytics.component';
import { HighchartsChartModule } from 'highcharts-angular';


@NgModule({
  declarations: [
    EncadrantComponent,
    HomeComponent,
    CreateComponent,
    DetailsComponent,
    UpdateComponent,
    AnalyticsComponent,
  ],
  imports: [
    CommonModule,
    EncadrantRoutingModule,
    FormsModule,
    HighchartsChartModule
  ]
})
export class EncadrantModule { }
