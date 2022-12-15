import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Projet} from "../model/projet";
import {Entreprise} from "../model/entreprise";

@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {
  public uri = environment.uri + 'Entreprise/';

  constructor(private http: HttpClient) { }
  getEntrepriseById(id:number) {
    return this.http.get<Projet[]>(this.uri + 'getAll/'+id);
  }

}
