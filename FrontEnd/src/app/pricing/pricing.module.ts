import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PricingRoutingModule } from './pricing-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { PricingComponent } from './pricing/pricing.component';


@NgModule({
  declarations: [PricingComponent],
  imports: [
    CommonModule,
    PricingRoutingModule,
    NgbModule
  ]
})
export class PricingModule { }
