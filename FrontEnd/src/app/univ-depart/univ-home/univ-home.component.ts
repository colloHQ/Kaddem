import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../model/departement';
import { Universite } from '../model/universite';
import { UnivDepartService } from '../univ-depart.service';

@Component({
  selector: 'app-univ-home',
  templateUrl: './univ-home.component.html',
  styleUrls: ['./univ-home.component.scss']
})
export class UnivHomeComponent implements OnInit {

  departs: Departement[]
  univs: Universite[]
  action: string
  title: string 

  constructor(
    public univDepartService: UnivDepartService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(){
    this.action = this.activatedRoute.snapshot.routeConfig.path
    console.log(this.activatedRoute.snapshot.routeConfig.path)
    if(this.action === "univ/home"){
      this.univDepartService.getAllDeparts().subscribe((data: Departement[])=>{
        console.log("hello")
        console.log(data)
        this.departs = data
      }) 
      this.title = "Universites"
    }
  }

  deleteDepart(depart: Departement){
    let i = this.departs.indexOf(depart)
    if(i!=-1) this.departs.splice(i,1)
    this.univDepartService.deleteDepart(depart.idDepartement).subscribe( res => {
      console.log('Depart deleted')
    })
  }

}
