import { Equipes } from './../../core/model/equipes';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-equipe',
  templateUrl: './card-equipe.component.html',
  styleUrls: ['./card-equipe.component.scss'],
})
export class CardEquipeComponent implements OnInit {
  @Input() currentEquipe: Equipes;
  constructor() {}

  ngOnInit(): void {}
}
