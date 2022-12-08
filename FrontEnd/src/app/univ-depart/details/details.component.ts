import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../model/departement';
import { Universite } from '../model/universite';
import { UnivDepartService } from '../univ-depart.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {
  depart: Departement
  univ: Universite
  action: string
  id: number
  title: string
  toUpdate: String 
  updateLink: string

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
    if(this.action === "univ/details/:univId"){
      this.title = "Universite"
      this.updateLink = '/univDepart/univ/update/'
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
      this.updateLink = '/univDepart/depart/update/'
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

  returnHome(){
    if(this.action === "univ/details/:univId") this.route.navigateByUrl("/univDepart/univ/home")
    else this.route.navigateByUrl("/univDepart/depart/home")
  }

  deleteEntity(){
    if(this.action === "univ/details/:univId"){
      this.univDepartService.deleteUniv(this.univ.idUniversite).subscribe( res => {
        console.log('Universite deleted')
        this.returnHome()
      })
    }
    else{
      this.univDepartService.deleteDepart(this.depart.idDepartement).subscribe( res => {
        console.log('Depart deleted')
        this.returnHome()
      })
    }
  }
}
