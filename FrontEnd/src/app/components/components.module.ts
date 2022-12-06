import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { ComponentsRoutingModule } from './components-routing.module';
import { AlertsComponent } from './alerts/alerts.component';
import { BadgeComponent } from './badge/badge.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { CardsComponent } from './cards/cards.component';
import { CarouselComponent } from './carousel/carousel.component';
import { AccordionComponent } from './accordion/accordion.component';
import { ListGroupsComponent } from './list-groups/list-groups.component';
import { MediaObjectsComponent } from './media-objects/media-objects.component';
import { ModalsComponent } from './modals/modals.component';
import { NavsComponent } from './navs/navs.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PaginationComponent } from './pagination/pagination.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { SpinnersComponent } from './spinners/spinners.component';
import { AvtarsChipsComponent } from './avtars-chips/avtars-chips.component';


@NgModule({
  declarations: [
    AlertsComponent, 
    BadgeComponent, 
    ButtonsComponent, 
    CardsComponent, 
    CarouselComponent, 
    AccordionComponent, 
    ListGroupsComponent, 
    MediaObjectsComponent, 
    ModalsComponent, 
    NavsComponent, 
    NavbarComponent, 
    PaginationComponent, 
    ProgressBarComponent, 
    SpinnersComponent, 
    AvtarsChipsComponent
  ],
  imports: [
    CommonModule,
    ComponentsRoutingModule,
    NgbModule
  ]
})
export class ComponentsModule { }
