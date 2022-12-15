import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-espace-equipe',
  templateUrl: './espace-equipe.component.html',
  styleUrls: ['./espace-equipe.component.scss'],
})
export class EspaceEquipeComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {
    // chat toggle
    $('.chat-toggle-btn').on('click', function () {
      $('.chat-wrapper').toggleClass('chat-toggled');
    });
    $('.chat-toggle-btn-mobile').on('click', function () {
      $('.chat-wrapper').removeClass('chat-toggled');
    });
  }
}
