import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { GridSystemComponent } from './grid-system/grid-system.component';
import { TypographyComponent } from './typography/typography.component';
import { TextUtilitiesComponent } from './text-utilities/text-utilities.component';


const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'grid-system',
        component: GridSystemComponent,
        data: {
          title: 'Analytics'
        }
      },
      {
        path: 'typography',
        component: TypographyComponent,
        data: {
          title: 'Sales'
        }
      },
      {
        path: 'text-utilities',
        component: TextUtilitiesComponent,
        data: {
          title: 'Sales'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContentRoutingModule { }
