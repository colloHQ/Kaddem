import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FileUploadComponent } from './file-upload/file-upload.component';
import { FormElementsComponent } from './form-elements/form-elements.component';
import { FormLayoutsComponent } from './form-layouts/form-layouts.component';
import { FormValidationComponent } from './form-validation/form-validation.component';
import { FormWizardComponent } from './form-wizard/form-wizard.component';
import { InputGroupsComponent } from './input-groups/input-groups.component';
import { Select2Component } from './select2/select2.component';
import { TextEditorComponent } from './text-editor/text-editor.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'form-elements',
        component: FormElementsComponent,
        data: {
          title: 'form-elements'
        }
      },
      {
        path: 'input-groups',
        component: InputGroupsComponent,
        data: {
          title: 'input-group'
        }
      },
      {
        path: 'form-layouts',
        component: FormLayoutsComponent,
        data: {
          title: 'form-layouts'
        }
      },
      {
        path: 'form-validation',
        component: FormValidationComponent,
        data: {
          title: 'Form Validation'
        }
      },
      {
        path: 'form-wizard',
        component: FormWizardComponent,
        data: {
          title: 'Form Wizard'
        }
      },
      {
        path: 'text-editor',
        component: TextEditorComponent,
        data: {
          title: 'Text Editor'
        }
      },
      {
        path: 'file-upload',
        component: FileUploadComponent,
        data: {
          title: 'File Upload'
        }
      },
      {
        path: 'select2',
        component: Select2Component,
        data: {
          title: 'Form Select2'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FormRoutingModule { }
