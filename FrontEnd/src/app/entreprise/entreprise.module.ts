import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EntrepriseRoutingModule } from './entreprise-routing.module';
import { EntrepriseComponent } from './entreprise.component';
import { ListEntrepriseComponent } from './list-entreprise/list-entreprise.component';
import { FormComponent } from './form/form.component';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { EntrepriseService } from '../core/service/entreprise.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';


@NgModule({
  declarations: [
    EntrepriseComponent,
    ListEntrepriseComponent,
    FormComponent
  ],
  imports: [
    CommonModule,
    EntrepriseRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule
    
  ],
  providers:[EntrepriseService]
})
export class EntrepriseModule { }
