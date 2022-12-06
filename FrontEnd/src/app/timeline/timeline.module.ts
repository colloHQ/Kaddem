import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TimelineRoutingModule } from './timeline-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { TimelineComponent } from './timeline/timeline.component';


@NgModule({
  declarations: [TimelineComponent],
  imports: [
    CommonModule,
    TimelineRoutingModule,
    NgbModule
  ]
})
export class TimelineModule { }
