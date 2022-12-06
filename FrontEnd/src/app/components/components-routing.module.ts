import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AccordionComponent } from './accordion/accordion.component';
import { AlertsComponent } from './alerts/alerts.component';
import { AvtarsChipsComponent } from './avtars-chips/avtars-chips.component';
import { BadgeComponent } from './badge/badge.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { CardsComponent } from './cards/cards.component';
import { CarouselComponent } from './carousel/carousel.component';
import { ListGroupsComponent } from './list-groups/list-groups.component';
import { MediaObjectsComponent } from './media-objects/media-objects.component';
import { ModalsComponent } from './modals/modals.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NavsComponent } from './navs/navs.component';
import { PaginationComponent } from './pagination/pagination.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { SpinnersComponent } from './spinners/spinners.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'alerts',
        component: AlertsComponent,
        data: {
          title: 'Alerts'
        }
      },
      {
        path: 'badge',
        component: BadgeComponent,
        data: {
          title: 'Badge'
        }
      },
      {
        path: 'buttons',
        component: ButtonsComponent,
        data: {
          title: 'buttons'
        }
      },
      {
        path: 'cards',
        component: CardsComponent,
        data: {
          title: 'Cards'
        }
      },
      {
        path: 'carousel',
        component: CarouselComponent,
        data: {
          title: 'Carousel'
        }
      },
      {
        path: 'acordians',
        component: AccordionComponent,
        data: {
          title: 'Acordians'
        }
      },
      {
        path: 'list-groups',
        component: ListGroupsComponent,
        data: {
          title: 'List Groups'
        }
      },
      {
        path: 'media-objects',
        component: MediaObjectsComponent,
        data: {
          title: 'Media Objects'
        }
      },
      {
        path: 'modals',
        component: ModalsComponent,
        data: {
          title: 'Modals'
        }
      },
      {
        path: 'navs',
        component: NavsComponent,
        data: {
          title: 'Navs'
        }
      },
      {
        path: 'navbar',
        component: NavbarComponent,
        data: {
          title: 'Navbar'
        }
      },
      {
        path: 'pagination',
        component: PaginationComponent,
        data: {
          title: 'Pagination'
        }
      },
      {
        path: 'progress-bar',
        component: ProgressBarComponent,
        data: {
          title: 'Progress Bar'
        }
      },
      {
        path: 'spinners',
        component: SpinnersComponent,
        data: {
          title: 'Spinners'
        }
      },
      {
        path: 'avtars-chips',
        component: AvtarsChipsComponent,
        data: {
          title: 'Avtars Chips'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ComponentsRoutingModule { }
