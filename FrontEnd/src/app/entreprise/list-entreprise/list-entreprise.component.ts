import { Component, OnInit } from '@angular/core';
import { Entreprise } from 'src/app/core/model/Entreprise';
import { EntrepriseService } from 'src/app/core/service/entreprise.service';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@Component({
  selector: 'app-list-entreprise',
  templateUrl: './list-entreprise.component.html',
  styleUrls: ['./list-entreprise.component.scss']
})
export class ListEntrepriseComponent implements OnInit {

  public listEntreprise:Entreprise[];
  searchTerm = '';
  term = '';
  constructor(private entrepriseService: EntrepriseService) { }

  ngOnInit(): void {
    this.entrepriseService.getAllEntreprises().subscribe(
      (data: Entreprise[]) => {
        this.listEntreprise = data;
      })
  }

  deleteEpse(e: Entreprise){
    let i = this.listEntreprise.indexOf(e)
    if(i!=-1) this.listEntreprise.splice(i,1)
    this.entrepriseService.deleteEnreprise(e.idEntreprise).subscribe( res => {
      console.log('Entreprise deleted')
    })
  }

}
