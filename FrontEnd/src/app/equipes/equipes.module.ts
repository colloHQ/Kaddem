import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EquipesRoutingModule } from './equipes-routing.module';
import { EquipesComponent } from './equipes.component';
import { FormEquipeComponent } from './form-equipe/form-equipe.component';
import { ListEquipeComponent } from './list-equipe/list-equipe.component';
import { DetailEquipeComponent } from './detail-equipe/detail-equipe.component';
import { AdminEquipeComponent } from './admin-equipe/admin-equipe.component';
import { EspaceEquipeComponent } from './espace-equipe/espace-equipe.component';
import { DashboardEquipeComponent } from './dashboard-equipe/dashboard-equipe.component';
import { CardEquipeComponent } from './card-equipe/card-equipe.component';

@NgModule({
  declarations: [
    EquipesComponent,
    FormEquipeComponent,
    ListEquipeComponent,
    DetailEquipeComponent,
    AdminEquipeComponent,
    EspaceEquipeComponent,
    DashboardEquipeComponent,
    CardEquipeComponent,
  ],
  imports: [
    CommonModule,
    EquipesRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class EquipesModule {}
