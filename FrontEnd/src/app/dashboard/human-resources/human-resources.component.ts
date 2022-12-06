import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-human-resources',
  templateUrl: './human-resources.component.html',
  styleUrls: ['./human-resources.component.scss']
})
export class HumanResourcesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $.getScript("./assets/js/human-resources.js")

  }

}
