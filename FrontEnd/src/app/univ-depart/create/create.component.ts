import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Departement } from '../model/departement';
import { UnivDepartService } from '../univ-depart.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit{

  public depart: Departement

  constructor(
    public univDepartService: UnivDepartService,
    private router: Router
  ) {
    
  }
  ngOnInit(): void {
    this.depart = new Departement()
  }

  addDepart(){
    this.univDepartService.createDepart(this.depart).subscribe(res => {
      console.log('Depart created!')
      this.router.navigateByUrl('/univDepart/depart/home')
    })
  }

  
}
