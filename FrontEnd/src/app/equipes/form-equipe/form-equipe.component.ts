import { Equipes } from './../../core/model/equipes';
import { EquipesService } from './../../core/service/equipes.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-equipe',
  templateUrl: './form-equipe.component.html',
  styleUrls: ['./form-equipe.component.scss'],
})
export class FormEquipeComponent implements OnInit {
  equipeForm: FormGroup;
  public action: string;
  equipe: Equipes;

  constructor(
    public fb: FormBuilder,
    private router: Router,
    public equipesService: EquipesService,
    private currentRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    //update
    let idEquipe = this.currentRoute.snapshot.params['idEquipe'];
    if (idEquipe != null) {
      this.action = 'Update';
      this.equipesService.getEquipeById(idEquipe).subscribe((data: Equipes) => {
        console.log(data);
        this.equipe = data;
        this.equipeForm.patchValue({
          idEquipe: this.equipe.idEquipe,
          nomEquipe: this.equipe.nomEquipe,
          niveau: this.equipe.niveau,
          photos: this.equipe.photos,
        });
      });
    }
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
    if (this.action == 'Update') {
      this.equipesService
        .updateEquipe(this.equipeForm.value)
        .subscribe((res) => {
          console.log('Equipe updated!');
          this.router.navigateByUrl('/equipes/list');
        });
    } else {
      this.equipesService.addEquipe(this.equipeForm.value).subscribe((res) => {
        console.log('Equipe created!');
        this.router.navigateByUrl('/equipes/list');
      });
    }
  }
}
