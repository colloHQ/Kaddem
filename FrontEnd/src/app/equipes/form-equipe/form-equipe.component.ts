import { EquipesService } from './../../core/service/equipes.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-equipe',
  templateUrl: './form-equipe.component.html',
  styleUrls: ['./form-equipe.component.scss'],
})
export class FormEquipeComponent implements OnInit {
  equipeForm: FormGroup;

  constructor(
    public fb: FormBuilder,
    private router: Router,
    public equipesService: EquipesService
  ) {}

  ngOnInit(): void {
    this.equipeForm = this.fb.group({
      nomEquipe: [''],
      niveau: [''],
      photos: [''],
    });
  }
  verifyForm() {
    console.log(this.equipeForm.value.nomEquipe);
    console.log(this.equipeForm.value.niveau);
    console.log(this.equipeForm.value.photos);
    //cnx backend
  }

  submitForm() {
    this.equipesService.addEquipe(this.equipeForm.value).subscribe((res) => {
      console.log('Equipe created!');
      this.router.navigateByUrl('/equipes/list');
    });
  }
}
