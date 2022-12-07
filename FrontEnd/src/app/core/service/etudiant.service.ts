import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Etudiant } from '../model/etudiant';

@Injectable({
  providedIn: 'root'
})
export class EtudiantService {
  public uri = environment.uri + 'Etudiant/'
  constructor(private http: HttpClient) { }
  getAllEtudiant() {
    return this.http.get<Etudiant[]>(this.uri+"getAll")
  }
  addEtudiant(e: Etudiant) {
    return this.http.post(this.uri, e)
  }
  deleteEtudiant(id: number) {
    return this.http.delete(this.uri + id)
  }
  updateEtudiant(e: Etudiant) {
    return this.http.put(this.uri + e.idEtudiant, e)
  }
}
