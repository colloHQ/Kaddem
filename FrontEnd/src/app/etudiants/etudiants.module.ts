import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EtudiantsRoutingModule } from './etudiants-routing.module';
import { EtudiantsComponent } from './etudiants.component';
import { ListEtudiantComponent } from './list-etudiant/list-etudiant.component';


@NgModule({
  declarations: [
    EtudiantsComponent,
    ListEtudiantComponent
  ],
  imports: [
    CommonModule,
    EtudiantsRoutingModule
  ]
})
export class EtudiantsModule { }
