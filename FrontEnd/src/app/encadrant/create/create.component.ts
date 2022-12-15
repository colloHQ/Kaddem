import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Encadrant } from 'src/app/core/model/encadrant';
import { EncadrantService } from 'src/app/core/service/encadrant.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {

  encadrant: Encadrant

  constructor(
    private encadrantService: EncadrantService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.encadrant = new Encadrant()
  }

  addEncadrant(){
    this.encadrantService.addEncadrant(this.encadrant).subscribe( res => {
      console.log("Encadrant Added")
      this.router.navigateByUrl("/encadrant/home")
    })
  }

}
