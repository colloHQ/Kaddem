import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EtudiantsRoutingModule } from './etudiants-routing.module';
import { EtudiantsComponent } from './etudiants.component';
import { ListEtudiantComponent } from './list-etudiant/list-etudiant.component';
import { FormComponent } from './form/form.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [EtudiantsComponent, ListEtudiantComponent, FormComponent],
  imports: [CommonModule, EtudiantsRoutingModule, FormsModule],
})
export class EtudiantsModule {}
