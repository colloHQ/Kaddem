import { Equipes } from './../../core/model/equipes';
import { EquipesService } from './../../core/service/equipes.service';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-list-equipe',
  templateUrl: './list-equipe.component.html',
  styleUrls: ['./list-equipe.component.scss'],
})
export class ListEquipeComponent implements OnInit {
  public listEquipe: Equipes[];
  currentEquipe: Equipes;
  constructor(private equipesService: EquipesService) {}

  ngOnInit(): void {
    this.equipesService.getAllEquipes().subscribe((data: Equipes[]) => {
      this.listEquipe = data;
    });
  }
  deleteEquipe(equipe: Equipes) {
    let i = this.listEquipe.indexOf(equipe);
    if (i != -1) this.listEquipe.splice(i, 1);
    this.equipesService.deleteEquipe(equipe.idEquipe).subscribe((res) => {
      console.log('Equipe deleted');
    });
  }
}
