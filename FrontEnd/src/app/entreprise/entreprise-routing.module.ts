import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntrepriseComponent } from './entreprise.component';
import { ListEntrepriseComponent } from './list-entreprise/list-entreprise.component';
import { FormComponent } from './form/form.component';

const routes: Routes =
 [{ path: '', component: EntrepriseComponent },
  { path:'list',component:ListEntrepriseComponent},
  { path:'add',component:FormComponent},
  { path:'update/:idEntreprise',component:FormComponent}];
  

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EntrepriseRoutingModule { }
