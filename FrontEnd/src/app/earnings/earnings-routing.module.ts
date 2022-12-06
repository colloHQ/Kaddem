import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EarningsComponent } from './earnings/earnings.component';

const routes: Routes = [
  { path: '' , component: EarningsComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EarningsRoutingModule { }
