import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DownloadsRoutingModule } from './downloads-routing.module';
import { DownloadsComponent } from './downloads/downloads.component';


@NgModule({
  declarations: [
    DownloadsComponent
  ],
  imports: [
    CommonModule,
    DownloadsRoutingModule
  ]
})
export class DownloadsModule { }
