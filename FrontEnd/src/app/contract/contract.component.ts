import { Specialite } from './../core/model/Specialite';
import { HttpErrorResponse } from '@angular/common/http';
import { ContractService } from './../core/service/contract.service';
import { Component, OnInit } from '@angular/core';
import { Contrat } from '../core/model/Contrat';
import { NgForm } from '@angular/forms';
import { Etudiant } from '../core/model/etudiant';

@Component({
  selector: 'app-contract',
  templateUrl: './contract.component.html',
  styleUrls: ['./contract.component.scss'],
})
export class ContractComponent implements OnInit {
  contracts: Contrat[];
  specializedContracts: Contrat[];
  chiffreAffaire: Number;
  validContracts: Number;
  newContract: Contrat;
  singleContract: Contrat;

  constructor(private contractService: ContractService) {}

  ngOnInit(): void {}
  getAllContracts(): void {
    this.contractService.getAllContracts().subscribe({
      next: (response: Contrat[]) => {
        this.contracts = response;
      },
      error: (err: HttpErrorResponse) => {
        console.log(err.message);
      },
      complete: () => {
        console.log(this.contracts);
      },
    });
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
  getChiffreAffaire(form: NgForm) {
    this.contractService
      .getChiffreAffaireEntreDeuxDate(
        form.form.value.startDate,
        form.form.value.endDate
      )
      .subscribe({
        next: (response) => {
          this.chiffreAffaire = response;
        },
        error: (err: HttpErrorResponse) => {
          console.log(err.message);
        },
        complete: () => {
          console.log('complete :>');
        },
      });
    console.log(form.form.value);
  }
}
