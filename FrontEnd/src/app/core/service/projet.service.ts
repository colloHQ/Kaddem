import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Projet } from '../model/projet';
import {Entreprise} from "../model/entreprise";

@Injectable({
  providedIn: 'root'
})
export class ProjetService {

  public uri = environment.uri + 'Projet/';

  constructor(private http: HttpClient) {}

  getAllProjet() {
    return this.http.get<Projet[]>(this.uri + 'getAll');
  }
  addProjet(p: Projet,id:number) {
    return this.http.post(this.uri + 'add/'+id, p );
  }
  deleteProjet(id: number) {
    return this.http.delete(this.uri + 'delete/' + id);
  }
  updateProjet(p: Projet,id:number) {
    return this.http.put(this.uri + 'update/'+ id, p);
  }
  getProjet(id:number){
    return this.http.get<Projet>(this.uri + 'getById/'+id);
  }
  statusToFinished(p: Projet){
    return this.http.put(this.uri + 'ToFinished', p);
  }
}


