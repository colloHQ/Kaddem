import { Specialite } from './../../core/model/Specialite';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';
import { ContractService } from './../../core/service/contract.service';
import { Component, OnInit } from '@angular/core';
import { Contrat } from 'src/app/core/model/Contrat';
import { Modal } from 'bootstrap';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.scss'],
})
export class ContractListComponent implements OnInit {
  contracts: Contrat[];
  isArchived: string;
  specialite: string;
  filtredContracts: Contrat[];
  editModal: Modal;
  deleteModal: Modal;
  addModal: Modal;
  newContract: Contrat;
  editContrat: Contrat = new Contrat(
    0,
    true,
    new Date(),
    new Date(),
    Specialite.IA,
    null
  );
  toDeleteId: number;

  constructor(private contractService: ContractService) {}

  ngOnInit(): void {
    this.getAllContracts();
  }
  sortByStartDate(contracts: Contrat[]): Contrat[] {
    return contracts.sort(
      (a: Contrat, b: Contrat) => a.idContrat - b.idContrat
    );
  }
  filterContracts(): Contrat[] {
    const x = this.isArchived == 'true';
    if (this.isArchived !== 'all')
      this.filtredContracts = this.contracts.filter(
        (contrat) => contrat.archive === x
      );
    else this.filtredContracts = this.contracts;

    return this.filtredContracts;
  }
  addContrat(form: NgForm) {
    console.log(form.form.value);
    this.newContract = new Contrat(
      9,
      form.form.value.archive,
      new Date(form.form.value.startDate),
      new Date(form.form.value.endDate),
      form.form.value.specialite,
      null
    );
    this.contractService.addContract(this.newContract).subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err.message);
      },
      complete: () => {
        console.log('complete :>');
      },
    });
  }

  getAllContracts(): void {
    this.contractService.getAllContracts().subscribe({
      next: (response: Contrat[]) => {
        this.contracts = response;
        this.filtredContracts = this.contracts;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      },
      complete: () => {
        console.log('complete :>');
      },
    });
  }
  openEdit(contrat: Contrat) {
    this.editContrat = contrat;
    this.editModal = new Modal(
      document.getElementById('editModal'),
      { keyboard: false }
    );
    this.editModal?.show();
  }
  closeEdit() {
    this.editModal?.toggle();
  }
  saveEdit(form: NgForm) {
    this.editContrat.dateDebutContrat = form.form.value.startDate;
    this.editContrat.dateFinContrat = form.form.value.endDate;
    this.editContrat.archive = form.form.value.archive;
    this.editContrat.specialite = form.form.value.specialite;
    this.contractService.updateContract(this.editContrat).subscribe({
      next: (response) => {
        console.log(response);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err.message);
      },
      complete: () => {
        console.log('complete :>');
      },
    });
    console.log(form.form.value);
    this.editModal?.toggle();
  }
  openAdd() {
    this.addModal = new window.bootstrap.Modal(
      document.getElementById('addModal'),
      { keyboard: false }
    );
    this.addModal?.show();
  }
  closeAdd() {
    this.addModal?.toggle();
  }
  saveAdd(form: NgForm) {
    this.addContrat(form.form.value);
    console.log(form.form.value);
    this.addModal?.toggle();
  }
  openDelete(id: number) {
    this.toDeleteId = id;
    this.deleteModal = new window.bootstrap.Modal(
      document.getElementById('deleteModal'),
      { keyboard: false }
    );
    this.deleteModal?.show();
  }
  closeDelete() {
    this.deleteModal?.toggle();
  }
  saveDelete() {
    // this.filtredContracts = this.filtredContracts.filter((contrat) => {
    //   contrat.idContrat != this.toDeleteId;
    // });
    this.contractService.deleteContract(this.toDeleteId);
    this.deleteModal?.toggle();
  }
}
