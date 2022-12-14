import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EntrepriseRoutingModule } from './entreprise-routing.module';
import { EntrepriseComponent } from './entreprise.component';
import { ListEntrepriseComponent } from './list-entreprise/list-entreprise.component';
import { FormComponent } from './form/form.component';
import { FormsModule  } from '@angular/forms';
import { EntrepriseService } from '../core/service/entreprise.service';


@NgModule({
  declarations: [
    EntrepriseComponent,
    ListEntrepriseComponent,
    FormComponent
  ],
  imports: [
    CommonModule,
    EntrepriseRoutingModule,
    FormsModule
    
  ],
  providers:[EntrepriseService]
})
export class EntrepriseModule { }
