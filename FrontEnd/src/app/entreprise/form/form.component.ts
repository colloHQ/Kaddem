import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Entreprise } from 'src/app/core/model/entreprise';
import { Secteur } from 'src/app/core/model/Secteur';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { EntrepriseService } from 'src/app/core/service/entreprise.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {

  public ajouterForm:FormGroup

  public e:Entreprise
  public action:string
  public title:string
  id: number


  public secteurEnum = Secteur;
  

  constructor(private entrepriseService:EntrepriseService,private route: Router,
    private activatedRoute: ActivatedRoute,private fb:FormBuilder) { }

    
  ngOnInit(): void {
    this.e = new Entreprise()
    this.action = this.activatedRoute.snapshot.routeConfig.path
    console.log(this.activatedRoute.snapshot.routeConfig.path)

    this.id = this.activatedRoute.snapshot.params["idEntreprise"]
    console.log(this.id)

    if (this.id!=null){
      //update  
      this.action = 'update'
      this.title = 'Modifier Entreprise'
      this.entrepriseService.getEntrepriseById(this.id).subscribe(
        (data:Entreprise)=>(this.e=data)
      )
    }else{
      //add
      this.action = 'Add '
      this.title = 'Nouvelle Entreprise'
      this.e = new Entreprise()
    }

    this.ajouterForm = this.fb.group(
      {nom:['',Validators.required],
      password:['',Validators.required,Validators.minLength(5)]}
    )


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


