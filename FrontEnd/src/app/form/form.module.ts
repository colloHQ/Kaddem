import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormRoutingModule } from './form-routing.module';
import { EditorModule } from '@tinymce/tinymce-angular';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FormElementsComponent } from './form-elements/form-elements.component';
import { InputGroupsComponent } from './input-groups/input-groups.component';
import { FormLayoutsComponent } from './form-layouts/form-layouts.component';
import { FormValidationComponent } from './form-validation/form-validation.component';
import { FormWizardComponent } from './form-wizard/form-wizard.component';
import { TextEditorComponent } from './text-editor/text-editor.component';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { Select2Component } from './select2/select2.component';


@NgModule({
  declarations: [
    FormElementsComponent, 
    InputGroupsComponent, 
    FormLayoutsComponent, 
    FormValidationComponent, 
    FormWizardComponent, 
    TextEditorComponent, 
    FileUploadComponent, 
    Select2Component
  ],
  imports: [
    CommonModule,
    FormRoutingModule,
    EditorModule,
    NgbModule
  ]
})
export class FormModule { }
