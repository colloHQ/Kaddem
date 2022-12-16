import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Etudiant } from 'src/app/core/model/etudiant';
import { EtudiantService } from 'src/app/core/service/etudiant.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  action: string
  id: number
  listEtudiant: Etudiant[]
  etudiant: Etudiant

  constructor(
    public etudiantService: EtudiantService,
    private route: Router, 
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.action = this.activatedRoute.snapshot.params["idEtudiant"]
    this.id = parseInt(this.action)
    console.log(this.id)
    this.etudiantService.getById(this.id).subscribe(
      data => this.etudiant = data
    )

  }

  add(){
    this.etudiantService.updateEtudiant(this.etudiant).subscribe( res =>
      this.route.navigateByUrl("/list")
    )
  }

}
