import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Entreprise } from 'src/app/core/model/Entreprise';
import { Secteur } from 'src/app/core/model/Secteur';
import { EntrepriseService } from 'src/app/core/service/entreprise.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  public e:Entreprise
  public action:string
  public button:string
  public title:string


  keys = Object.keys;
  public secteurEnum = Secteur;
  

  constructor(private entrepriseService:EntrepriseService,private route: Router,
    private activatedRoute: ActivatedRoute) { }

    
  ngOnInit(): void {
    this.e = new Entreprise()
    this.action = this.activatedRoute.snapshot.routeConfig.path
    console.log(this.activatedRoute.snapshot.routeConfig.path)

    let id = this.activatedRoute.snapshot.params["idEntreprise"]
    console.log(id)

    if (id!=null){
      //update  
      this.action = 'update'
      this.button = 'Modifier'
      this.title = 'Modifier Entreprise'
      this.entrepriseService.getEntrepriseById(id).subscribe(
        (data:Entreprise)=>(this.e=data)
      )
    }else{
      //add
      this.action = 'Add '
      this.button = 'Ajouter'
      this.title = 'Nouvelle Entreprise'
      this.e = new Entreprise()
    }
  }
  saveEntreprise(){

    if(this.action == 'update/idEntreprise'){
      console.log(this.e)
      this.entrepriseService.updateEntreprise(this.e).subscribe(
        ()=>this.route.navigate(['Entreprise/list']),
        ()=>{console.log('error'),
        ()=>{console.log('complete')}}
      );
    }else{
      this.entrepriseService.addEntreprise(this.e).subscribe(
        ()=>this.route.navigate(['Entreprise/list']),
        ()=>{console.log('error'),
        ()=>{console.log('complete')}}
      );
      
    }
  }


  }


