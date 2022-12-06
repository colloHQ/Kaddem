import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-form-wizard',
  templateUrl: './form-wizard.component.html',
  styleUrls: ['./form-wizard.component.scss']
})
export class FormWizardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $.getScript('./assets/plugins/smartwizard/dist/js/jquery.smartWizard.min.js');
	$.getScript('./assets/js/custom-smartWizard.js');
  }

}
