import { FormEquipeComponent } from './form-equipe/form-equipe.component';
import { DashboardEquipeComponent } from './dashboard-equipe/dashboard-equipe.component';
import { AdminEquipeComponent } from './admin-equipe/admin-equipe.component';
import { EspaceEquipeComponent } from './espace-equipe/espace-equipe.component';
import { ListEquipeComponent } from './list-equipe/list-equipe.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EquipesComponent } from './equipes.component';

const routes: Routes = [
  { path: '', component: EquipesComponent },
  { path: 'list', component: ListEquipeComponent },
  { path: 'espace', component: EspaceEquipeComponent },
  { path: 'admin', component: AdminEquipeComponent },
  { path: 'dashboard', component: DashboardEquipeComponent },
  { path: 'form', component: FormEquipeComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class EquipesRoutingModule {}
