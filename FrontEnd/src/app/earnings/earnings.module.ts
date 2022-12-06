import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EarningsRoutingModule } from './earnings-routing.module';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';

import { EarningsComponent } from './earnings/earnings.component';


@NgModule({
  declarations: [
    EarningsComponent
  ],
  imports: [
    CommonModule,
    EarningsRoutingModule,
    PerfectScrollbarModule
  ]
})
export class EarningsModule { }
