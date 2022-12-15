import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EtudiantsComponent } from './etudiants.component';
import { FormComponent } from './form/form.component';
import { ListEtudiantComponent } from './list-etudiant/list-etudiant.component';

const routes: Routes = [
  { path: '', component: EtudiantsComponent },
  { path: 'list', component: ListEtudiantComponent },
  { path: 'add', component: FormComponent },
  { path: 'update/:idEtudiant', component: FormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EtudiantsRoutingModule {}
