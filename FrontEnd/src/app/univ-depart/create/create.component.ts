import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../model/departement';
import { Universite } from '../model/universite';
import { UnivDepartService } from '../univ-depart.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit{

  public toAdd: string
  univ: Universite
  depart: Departement
  action: string
  title: string

  constructor(
    public univDepartService: UnivDepartService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    
  }
  ngOnInit(): void {
    this.action = this.activatedRoute.snapshot.routeConfig.path
    console.log(this.activatedRoute.snapshot.routeConfig.path)
    if(this.action === "univ/create"){
      this.title = "Universite"
      this.univ = new Universite()
    }else{
      this.title = "Departement"
      this.depart = new Departement()
    }
  }

  add(){
    if(this.action === "univ/create"){
      this.univ.nomUniversite = this.toAdd
      console.log(this.univ.nomUniversite)
      this.univDepartService.createUniv(this.univ).subscribe(res => {
        console.log(this.univ)
        console.log('Universite created!')
        this.router.navigateByUrl('/univDepart/univ/home')
      })
    }else{
      this.depart.nomDepartement = this.toAdd
      this.univDepartService.createDepart(this.depart).subscribe(res => {
        console.log('Depart created!')
        this.router.navigateByUrl('/univDepart/depart/home')
      })
    }
  }



  
}
