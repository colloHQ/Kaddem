import { ContractComponent } from './contract.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ContractRoutingModule } from './contract-routing.module';
import { ContractListComponent } from './contract-list/contract-list.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [ContractComponent, ContractListComponent],
  exports: [ContractComponent, ContractListComponent],
  imports: [CommonModule, ContractRoutingModule, FormsModule],
})
export class ContractModule {}
