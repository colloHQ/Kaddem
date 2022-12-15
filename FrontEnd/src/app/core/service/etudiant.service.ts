import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Etudiant } from '../model/etudiant';

@Injectable({
  providedIn: 'root',
})
export class EtudiantService {
  public uri = environment.uri + 'Etudiant/';
  constructor(private http: HttpClient) {}
  getAllEtudiant() {
    return this.http.get<Etudiant[]>(this.uri + 'getAll');
  }
  addEtudiant(e: Etudiant) {
    return this.http.post(this.uri + 'add', e);
  }
  deleteEtudiant(id: number) {
    return this.http.delete(this.uri + 'delete/' + id);
  }
  updateEtudiant(e: Etudiant) {
    return this.http.put<Etudiant>(this.uri + "update/", e);
  }
  assignEtudiantToDepartement(e: Etudiant, idE: number, idD: number) {
    this.http.put(this.uri + 'assignToDepartement/' + idE + '/' + idD,e);
  }
  getById(id: number){
    return this.http.get<Etudiant>(this.uri + "getById/" + id)
  }
}
