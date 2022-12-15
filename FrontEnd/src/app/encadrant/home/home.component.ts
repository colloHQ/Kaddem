import { Component, OnInit } from '@angular/core';
import { Encadrant } from 'src/app/core/model/encadrant';
import { EncadrantService } from 'src/app/core/service/encadrant.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  encadrants: Encadrant[]

  constructor(
    private encadrantService: EncadrantService,
  ) { }

  ngOnInit(): void {
    this.encadrantService.getAllEncadrants().subscribe( data => {
      this.encadrants = data;
      console.log(this.encadrants)
    })
  }

  removeEncadrant(en: Encadrant){
    let i = this.encadrants.indexOf(en)
    if(i!=-1) this.encadrants.splice(i,1)
    this.encadrantService.deleteEncadrant(en.idEncadrant).subscribe( res => {
      console.log("encadrant deleted")
    })
  }

}
