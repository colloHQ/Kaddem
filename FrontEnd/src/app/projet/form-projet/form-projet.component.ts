import { Component, OnInit } from '@angular/core';
import {Projet} from "../../core/model/projet";
import {ProjetService} from "../../core/service/projet.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Entreprise} from "../../core/model/entreprise";
import {EntrepriseService} from "../../core/service/entreprise.service";

@Component({
  selector: 'app-form-projet',
  templateUrl: './form-projet.component.html',
  styleUrls: ['./form-projet.component.scss']
})
export class FormProjetComponent implements OnInit {
  public projet:Projet;
  public id:number;
  public identreprise:number;
  public idequipe:number;
  public action:string;
  constructor(private projetservice:ProjetService,private route:Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.projet=new Projet()
    this.action = this.activatedRoute.snapshot.routeConfig.path
    let id = this.activatedRoute.snapshot.params["idProjet"]
    if (id!=null){
      //update
      this.action = 'update'
      this.projetservice.getProjet(id).subscribe(
        (data:Projet)=>(this.projet=data)
      )
    }else{
      //add
      this.action = 'Add'
      this.projet = new Projet()
    }


  }
  saveProjet(){
    if(this.action=='update'){
      // @ts-ignore
      this.projetservice.updateProjet(this.projet,this.idequipe).subscribe(
        ()=>this.route.navigate(['Projet/list']),
        ()=>{console.log('error'),
          ()=>{console.log('complete')}}
      )
    }else{
      this.projetservice.addProjet(this.projet,this.identreprise).subscribe(
        ()=>this.route.navigate(['Projet/list']),
        ()=>{console.log('error'),
          ()=>{console.log('complete')}}
      )
    }}

}
