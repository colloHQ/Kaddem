import { Equipes } from './../../core/model/equipes';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-card-equipe',
  templateUrl: './card-equipe.component.html',
  styleUrls: ['./card-equipe.component.scss'],
})
export class CardEquipeComponent implements OnInit {
  @Input('currentEquipeChild') currentEquipeChild: Equipes;

  @Input() equipe: Equipes;
  @Output() msgChild = new EventEmitter<string>();
  constructor() {}

  ngOnInit(): void {}

  nbrProjets() {
    return this.equipe.projets.length;
  }
}
