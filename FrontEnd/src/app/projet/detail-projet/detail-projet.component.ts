import { Component, OnInit } from '@angular/core';
import {Projet} from "../../core/model/projet";
import {ProjetService} from "../../core/service/projet.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-detail-projet',
  templateUrl: './detail-projet.component.html',
  styleUrls: ['./detail-projet.component.scss']
})
export class DetailProjetComponent implements OnInit {
  public id:number;
  public projet:Projet;
  constructor(private projetservice:ProjetService,private route:Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.projet=new Projet()
    let id = this.activatedRoute.snapshot.params["idProjet"]
    this.projetservice.getProjet(id).subscribe(
      (data:Projet)=>(this.projet=data))
  }

}
