import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { WidgetsRoutingModule } from './widgets-routing.module';
import { WidgetsComponent } from './widgets.component';


@NgModule({
  declarations: [WidgetsComponent],
  imports: [
    CommonModule,
    WidgetsRoutingModule,
    NgbModule
  ]
})
export class WidgetsModule { }
