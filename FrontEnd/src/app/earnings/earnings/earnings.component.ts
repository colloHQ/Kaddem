import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-earnings',
  templateUrl: './earnings.component.html',
  styleUrls: ['./earnings.component.scss']
})
export class EarningsComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $.getScript('./assets/js/earnings.js');
  }

}
