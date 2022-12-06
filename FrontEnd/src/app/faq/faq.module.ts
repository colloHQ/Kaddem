import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FaqRoutingModule } from './faq-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FaqComponent } from './faq/faq.component';


@NgModule({
  declarations: [FaqComponent],
  imports: [
    CommonModule,
    FaqRoutingModule,
    NgbModule
  ]
})
export class FaqModule { }
