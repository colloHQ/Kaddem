import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Departement } from '../model/departement';
import { UnivDepartService } from '../univ-depart.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {
  public depart: Departement
  public action: string

  constructor(
    public univDepartService: UnivDepartService,
    private route: Router, 
    private activatedRoute: ActivatedRoute
  ) {
    
  }
  ngOnInit(): void {
    this.depart = new Departement()
    this.action = this.activatedRoute.snapshot.params['departId']
    console.log(this.action)
    let updateDepartId: number = parseInt(this.action)
    this.univDepartService.getDepartById(updateDepartId).subscribe(
      (data: Departement) => {
        console.log(data)
        this.depart = data
      })
      
  }

  updateDepart(){
    this.univDepartService.updateDepart(this.depart.idDepartement, this.depart).subscribe( res => {
      console.log('Depart Updated')
      this.route.navigateByUrl("/univDepart/depart/home")
    })
  }
}
