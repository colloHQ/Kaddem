import { Component, OnInit } from '@angular/core';
import { Etudiant } from 'src/app/core/model/etudiant';
import { EtudiantService } from 'src/app/core/service/etudiant.service';
import { Departement } from 'src/app/univ-depart/model/departement';
import { UnivDepartService } from 'src/app/univ-depart/univ-depart.service';

@Component({
  selector: 'app-list-etudiant',
  templateUrl: './list-etudiant.component.html',
  styleUrls: ['./list-etudiant.component.scss'],
})
export class ListEtudiantComponent implements OnInit {
  public listEtudiant: Etudiant[];
  public listDepartement: Departement[];
  constructor(
    private etudiantService: EtudiantService,
    private departementService: UnivDepartService
  ) {}

  ngOnInit(): void {
    this.etudiantService.getAllEtudiant().subscribe((data: Etudiant[]) => {
      this.listEtudiant = data;
      console.log(this.listEtudiant);
    });
    this.departementService.getAllDeparts().subscribe((data: Departement[]) => {
      this.listDepartement = data;
      console.log(this.listDepartement);
    });
  }

  //Delete
  delete(etudiant: Etudiant) {
    let i = this.listEtudiant.indexOf(etudiant);
    if (i != -1) this.listEtudiant.splice(i, 1);
    this.etudiantService
      .deleteEtudiant(etudiant.idEtudiant)
      .subscribe((res) => {
        console.log('etudiant deleted');
      });
    // this.etudiantService
    //   .deleteEtudiant(etudiant.idEtudiant)
    //   .subscribe((data) => {
    //     console.log(data);
    //     this.etudiantService.getAllEtudiant();
    //     location.reload();
    //   });
  }
}
