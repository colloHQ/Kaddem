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
      this.univDepartService.getAllUniv().subscribe((data: Universite[])=>{
        console.log("hello")
        console.log(data)
        this.univs = data
      }) 
      this.title = "Universites"
    }
  }

  deleteUniv(univ: Universite){
    let i = this.univs.indexOf(univ)
    if(i!=-1) this.univs.splice(i,1)
    this.univDepartService.deleteUniv(univ.idUniversite).subscribe( res => {
      console.log('Universite deleted')
    })
  }

}
