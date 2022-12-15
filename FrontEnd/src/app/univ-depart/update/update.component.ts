import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../model/departement';
import { Universite } from '../model/universite';
import { UnivDepartService } from '../univ-depart.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  depart: Departement
  univ: Universite
  action: string
  id: number
  title: string
  toUpdate: String 

  constructor(
    public univDepartService: UnivDepartService,
    private route: Router, 
    private activatedRoute: ActivatedRoute
  ) {
    
  }
  ngOnInit(): void {
    this.depart = new Departement()
    this.action = this.activatedRoute.snapshot.routeConfig.path
    console.log(this.activatedRoute.snapshot)
    if(this.action === "univ/update/:univId"){
      this.title = "Universite"
      this.univ = new Universite()
      this.id = parseInt(this.activatedRoute.snapshot.params['univId'])
      this.univDepartService.getUnivById(this.id).subscribe(
        (data: Universite) => {
          console.log(data)
          this.univ = data
          this.toUpdate = this.univ.nomUniversite
        })
    }else{
      this.title = "Departement"
      this.depart = new Departement()
      this.id = parseInt(this.activatedRoute.snapshot.params['departId'])
      this.univDepartService.getDepartById(this.id).subscribe(
        (data: Departement) => {
          console.log(data)
          this.depart = data
          this.toUpdate = this.depart.nomDepartement
        })
    }
    
      
  }

  update(){
    if(this.action === "univ/update/:univId"){
      this.univ.nomUniversite = this.toUpdate
      this.univDepartService.updateUniv(this.univ.idUniversite, this.univ).subscribe( res => {
        console.log('Universite Updated')
        this.route.navigateByUrl("/univDepart/univ/home")
      })
    }
    else{
      this.depart.nomDepartement = this.toUpdate
      this.univDepartService.updateDepart(this.depart.idDepartement, this.depart).subscribe( res => {
        console.log('Depart Updated')
        this.route.navigateByUrl("/univDepart/depart/home")
      })
    }
    
  }
}
