import { Component, OnInit } from '@angular/core';
import { ProjetService } from './../../core/service/projet.service';
import { Projet } from 'src/app/core/model/projet';
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-projet',
  templateUrl: './list-projet.component.html',
  styleUrls: ['./list-projet.component.scss'],
})
export class ListProjetComponent implements OnInit {
  public listProjet: Projet[];
  title: string;
  constructor(private prjService: ProjetService,private route:Router) { }

  ngOnInit(): void {
    this.prjService.getAllProjet().subscribe((data: Projet[]) =>
      this.listProjet = data);
  }


  delete(p: Projet) {
    let i = this.listProjet.indexOf(p);
    this.prjService.deleteProjet(p.idProjet).subscribe(
      ()=>this.listProjet.splice(i, 1)
    )}

  done(p:Projet){
      this.prjService.statusToFinished(p).subscribe(()=>this.route.navigate(['Projet/list']),
        ()=>{console.log('error'),
          ()=>{console.log('complete')}}
      );
    }


}
