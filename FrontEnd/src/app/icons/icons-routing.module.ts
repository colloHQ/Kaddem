import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BoxiconsComponent } from './boxicons/boxicons.component';
import { LineIconsComponent } from './line-icons/line-icons.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'line-icons',
        component: LineIconsComponent,
        data: {
          title: 'Line Icons'
        }
      },
      {
        path: 'boxicons',
        component: BoxiconsComponent,
        data: {
          title: 'Boxicons'
        }
      },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IconsRoutingModule { }
