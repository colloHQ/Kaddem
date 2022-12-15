import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { DetailsComponent } from './details/details.component';
import { EncadrantComponent } from './encadrant.component';
import { HomeComponent } from './home/home.component';
import { UpdateComponent } from './update/update.component';

const routes: Routes = [
  { path: '', component: EncadrantComponent , children: [
    { path:'home', component: HomeComponent },
    { path:'add', component: CreateComponent },
    { path:'update/:idEncadrant', component: UpdateComponent },
    { path:'details/:idEncadrant', component: DetailsComponent }
  ] }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EncadrantRoutingModule { }
