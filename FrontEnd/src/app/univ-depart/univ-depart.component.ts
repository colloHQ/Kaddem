import { Component, OnInit } from '@angular/core';
import { Departement } from './model/departement';
import { UnivDepartService } from './univ-depart.service';

@Component({
  selector: 'app-univ-depart',
  templateUrl: './univ-depart.component.html',
  styleUrls: ['./univ-depart.component.css']
})
export class UnivDepartComponent implements OnInit{
  constructor(
    public univDepartService: UnivDepartService
  ){}

  ngOnInit(){
    
  }
}
