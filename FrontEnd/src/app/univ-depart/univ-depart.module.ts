import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { UnivDepartRoutingModule } from './univ-depart-routing.module';
import { UnivDepartComponent } from './univ-depart.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { DetailsComponent } from './details/details.component';
import { CreateComponent } from './create/create.component';
import { UpdateComponent } from './update/update.component';
import { UnivHomeComponent } from './univ-home/univ-home.component';


@NgModule({
  declarations: [
    UnivDepartComponent,
    HomeComponent,
    DetailsComponent,
    CreateComponent,
    UpdateComponent,
    UnivHomeComponent
  ],
  imports: [
    CommonModule,
    UnivDepartRoutingModule,
    HttpClientModule,
    FormsModule
  ]
})
export class UnivDepartModule { }
