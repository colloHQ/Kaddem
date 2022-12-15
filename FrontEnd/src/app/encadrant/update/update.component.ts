import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Encadrant } from 'src/app/core/model/encadrant';
import { EncadrantService } from 'src/app/core/service/encadrant.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {

  encadrant: Encadrant
  id: number

  constructor(
    private encadrantService: EncadrantService,
    private router: Router, 
    private activatedRoute: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.encadrant = new Encadrant()
    this.id = parseInt(this.activatedRoute.snapshot.params["idEncadrant"])
    console.log(this.id)
    this.encadrantService.getEncadrantById(this.id).subscribe( data => {
      this.encadrant = data;
    })
  }

  updateEncadrant(){
    this.encadrantService.updateEncadrant(this.encadrant.idEncadrant, this.encadrant).subscribe(
      res => {
        console.log("Encdrant Updated")
        this.router.navigateByUrl("/encadrant/home")
      }
    )
  }

}
