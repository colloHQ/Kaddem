import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EtudiantsRoutingModule } from './etudiants-routing.module';
import { EtudiantsComponent } from './etudiants.component';
import { ListEtudiantComponent } from './list-etudiant/list-etudiant.component';
import { FormComponent } from './form/form.component';
import { FormsModule } from '@angular/forms';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { UpdateComponent } from './update/update.component';

@NgModule({
  declarations: [EtudiantsComponent, ListEtudiantComponent, FormComponent, UpdateComponent],
  imports: [CommonModule, EtudiantsRoutingModule, FormsModule, Ng2SearchPipeModule],
})
export class EtudiantsModule {}
