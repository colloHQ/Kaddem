import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProjetRoutingModule } from './projet-routing.module';
import { ProjetComponent } from './projet.component';
import { ListProjetComponent } from './list-projet/list-projet.component';
import { FormProjetComponent } from './form-projet/form-projet.component';
import { DetailProjetComponent } from './detail-projet/detail-projet.component';
import {FormsModule} from "@angular/forms";




@NgModule({
  declarations: [
    ProjetComponent,
    ListProjetComponent,
    FormProjetComponent,
    DetailProjetComponent
  ],
  imports: [
    CommonModule,
    ProjetRoutingModule,
    FormsModule
  ]
})
export class ProjetModule { }
