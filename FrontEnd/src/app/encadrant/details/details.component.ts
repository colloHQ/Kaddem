import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Encadrant } from 'src/app/core/model/encadrant';
import { EncadrantService } from 'src/app/core/service/encadrant.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.scss']
})
export class DetailsComponent implements OnInit {

  encadrant: Encadrant
  id: number

  constructor(
    private encadrantService: EncadrantService,
    private route: Router, 
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

  returnHome(){
    this.route.navigateByUrl("/encadrant/home")
  }

  removeEncadrant(){
    this.encadrantService.deleteEncadrant(this.encadrant.idEncadrant).subscribe(res => {
      console.log("Encadrant Deleted")
      this.returnHome()
    })
  }

}
