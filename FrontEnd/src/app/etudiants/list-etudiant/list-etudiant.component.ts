import { Component, OnInit } from '@angular/core';
import { Etudiant } from 'src/app/core/model/etudiant';
import { EtudiantService } from 'src/app/core/service/etudiant.service';

@Component({
  selector: 'app-list-etudiant',
  templateUrl: './list-etudiant.component.html',
  styleUrls: ['./list-etudiant.component.scss']
})
export class ListEtudiantComponent implements OnInit {

  public listEtudiant: Etudiant[];

  constructor(private etudiantService: EtudiantService) { }

  ngOnInit(): void {

    this.etudiantService.getAllEtudiant().subscribe(
      (data: Etudiant[]) => {
        this.listEtudiant = data;
      })



  }
}
