import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormProjetComponent } from './form-projet/form-projet.component';
import { ListProjetComponent } from './list-projet/list-projet.component';
import { ProjetComponent } from './projet.component';
import {DetailProjetComponent} from "./detail-projet/detail-projet.component";

const routes: Routes = [
  { path: '', component: ProjetComponent },
  { path: 'list', component: ListProjetComponent },
  { path: 'form', component: FormProjetComponent },
  { path: 'update/:idProjet', component: FormProjetComponent },
  { path: 'detail/:idProjet', component: DetailProjetComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProjetRoutingModule { }
