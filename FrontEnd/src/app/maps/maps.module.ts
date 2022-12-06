import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AgmCoreModule } from '@agm/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MapsRoutingModule } from './maps-routing.module';

import { GoogleComponent } from './google/google.component';
import { FullscreenComponent } from './fullscreen/fullscreen.component';

@NgModule({
  declarations: [
    GoogleComponent,
    FullscreenComponent
  ],
  imports: [
    CommonModule,
    MapsRoutingModule,
    NgbModule,
    AgmCoreModule
  ]
})
export class MapsModule { }
