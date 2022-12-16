import { ContractListComponent } from './contract-list/contract-list.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContractComponent } from './contract.component';

const routes: Routes = [
  {
    path: '',
    children: [
      { path: 'list', component: ContractListComponent },
      { path: 'addContrat', component: ContractComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ContractRoutingModule {}
