import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { DetailsComponent } from './details/details.component';
import { HomeComponent } from './home/home.component';
import { UnivDepartComponent } from './univ-depart.component';
import { UnivHomeComponent } from './univ-home/univ-home.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
  { path: '', redirectTo: 'depart/home', pathMatch: 'full'},
  { path: 'depart/home', component: HomeComponent },
  { path: 'depart/details/:departId', component: DetailsComponent },
  { path: 'depart/create', component: CreateComponent },
  { path: 'depart/update/:departId', component: UpdateComponent },
  { path: 'univ/home', component: UnivHomeComponent },
  { path: 'univ/details/:univId', component: DetailsComponent },
  { path: 'univ/create', component: CreateComponent },
  { path: 'univ/update/:univId', component: UpdateComponent }  
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UnivDepartRoutingModule { }
