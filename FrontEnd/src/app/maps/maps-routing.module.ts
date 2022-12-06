import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { GoogleComponent } from './google/google.component';
import { FullscreenComponent } from './fullscreen/fullscreen.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'google-maps',
        component: GoogleComponent,
        data: {
          title: 'Google Map'
        }
      },
      {
        path: 'fullscreen',
        component: FullscreenComponent,
        data: {
          title: 'Full Screen Map'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MapsRoutingModule { }
