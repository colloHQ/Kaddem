import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { th } from 'date-fns/locale';
import { environment } from 'src/environments/environment';
import { Entreprise } from '../model/entreprise';


@Injectable({
  providedIn: 'root'
})
export class EntrepriseService {
  public uri = environment.uri + 'Entreprise/'
  constructor(private http: HttpClient) { }
  getAllEntreprises() {
    return this.http.get<Entreprise[]>(this.uri+"getAll")
  }
  getEntrepriseById(IdE:number){
    return this.http.get<Entreprise>(this.uri+'getById/'+IdE)
  }
  addEntreprise(e: Entreprise) {
    return this.http.post(this.uri+"add", e)
  }
  deleteEnreprise(id: number) {
    return this.http.delete(this.uri+"delete/" + id)
  }
  updateEntreprise(e: Entreprise) {
    return this.http.put(this.uri +"update/"+ e.idEntreprise, e)
  }
  BestEnpseOfTheYear(y:number){
    return this.http.get(this.uri+"bestEntrepriseOfTheYear/"+y)
  }
}
