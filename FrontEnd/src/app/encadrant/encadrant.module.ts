import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EncadrantRoutingModule } from './encadrant-routing.module';
import { EncadrantComponent } from './encadrant.component';
import { HomeComponent } from './home/home.component';
import { CreateComponent } from './create/create.component';
import { DetailsComponent } from './details/details.component';
import { UpdateComponent } from './update/update.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    EncadrantComponent,
    HomeComponent,
    CreateComponent,
    DetailsComponent,
    UpdateComponent
  ],
  imports: [
    CommonModule,
    EncadrantRoutingModule,
    FormsModule
  ]
})
export class EncadrantModule { }
