import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ComingSoonComponent } from './coming-soon/coming-soon.component';
import { Error404Component } from './error404/error404.component';
import { Error500Component } from './error500/error500.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'error-404',
        component: Error404Component,
        data: {
          title: 'Error 404'
        }
      },
      {
        path: 'error-500',
        component: Error500Component,
        data: {
          title: 'Error 500'
        }
      },
      {
        path: 'coming-soon',
        component: ComingSoonComponent,
        data: {
          title: 'Coming Soon'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ErrorRoutingModule { }
