import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { IconsRoutingModule } from './icons-routing.module';
import { LineIconsComponent } from './line-icons/line-icons.component';
import { BoxiconsComponent } from './boxicons/boxicons.component';


@NgModule({
  declarations: [
    LineIconsComponent, 
    BoxiconsComponent
  ],
  imports: [
    CommonModule,
    IconsRoutingModule,
    NgbModule
  ]
})
export class IconsModule { }
