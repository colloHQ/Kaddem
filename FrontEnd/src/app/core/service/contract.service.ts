import {
  HttpClient,
  HttpErrorResponse,
  HttpResponse,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Contrat } from '../model/Contrat';
import { Etudiant } from '../model/etudiant';
import { Specialite } from '../model/Specialite';

@Injectable({
  providedIn: 'root',
})
export class ContractService {
  contracts: Contrat[];
  url = environment.uri + 'Contrat/';
  constructor(private http: HttpClient) {}

  getAllContracts(): Observable<Contrat[]> {
    return this.http.get<Contrat[]>(this.url + 'getAll');
  }
  getContractById(id: Number): Observable<Contrat> {
    return this.http.get<Contrat>(this.url + 'getById/' + id);
  }
  addContract(contract: Contrat): Observable<Contrat> {
    return this.http.post<Contrat>(this.url + 'add', contract);
  }
  updateContract(contract: Contrat): Observable<Contrat> {
    return this.http.put<Contrat>(this.url + 'update', contract);
  }
  deleteContract(id: number): void {
    this.http.delete(this.url + 'delete/' + id).subscribe({
      next: (response) => {
        console.log(response);
        console.log(`contrat with id :${id} has been deleted successfully !`);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err.message);
      },
      complete: () => {
        console.log('complete :>');
      },
    });
  }
  affectContractToEtudiant(
    contrat: Contrat,
    nomE: string,
    prenomE: string
  ): Observable<Contrat> {
    return this.http.post<Contrat>(
      this.url + `affectToEtudiant/${nomE}/${prenomE}`,
      contrat
    );
  }
  getChiffreAffaireEntreDeuxDate(
    startDate: Date,
    endDate: Date
  ): Observable<number> {
    return this.http.get<number>(this.url + `getCA/${startDate}/${endDate}`);
  }
  getValidContracts(startDate: Date, endDate: Date): Observable<number> {
    return this.http.get<number>(
      this.url + `getValide/${startDate}/${endDate}`
    );
  }
  getContractsBySpecialite(specialite: Specialite): Observable<Contrat[]> {
    return this.http.get<Contrat[]>(this.url + `getBySpecialite/${specialite}`);
  }
}
