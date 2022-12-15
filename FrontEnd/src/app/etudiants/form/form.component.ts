import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Console } from 'console';
import { Etudiant } from 'src/app/core/model/etudiant';
import { Option } from 'src/app/core/model/option';
import { EtudiantService } from 'src/app/core/service/etudiant.service';
import { Departement } from 'src/app/univ-depart/model/departement';
import { UnivDepartService } from 'src/app/univ-depart/univ-depart.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  public listDepartement: Departement[];
  public idDepart: number;
  public etudiant: Etudiant;
  option: Option;
  public listEtudiant: Etudiant[];

  constructor(
    private departementService: UnivDepartService,
    private etudiantService: EtudiantService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.etudiant = new Etudiant();
    this.departementService.getAllDeparts().subscribe((data: Departement[]) => {
      this.listDepartement = data;
      console.log(this.listDepartement);
    });
  }

  add() {
    this.etudiantService.addEtudiant(this.etudiant).subscribe((res) => {
      console.log('etudiant added');
      console.log(this.idDepart);
      console.log(this.etudiant.idEtudiant);
      this.router.navigateByUrl('/etudiants/list');
      this.etudiantService.getAllEtudiant().subscribe((data: Etudiant[]) => {
        this.listEtudiant = data;
        console.log(this.listEtudiant);
      });
      this.etudiant= this.listEtudiant[this.listEtudiant.length]
      console.log(this.listEtudiant[this.listEtudiant.length]);
      
      this.etudiantService.assignEtudiantToDepartement(
        this.etudiant,
        this.etudiant.idEtudiant,
        this.idDepart
        
      );
    });
   
   
  }
}
