import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ApplicationRoutingModule } from './application-routing.module';

import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';

import { NgbModalModule, NgbDatepickerModule, NgbTimepickerModule } from '@ng-bootstrap/ng-bootstrap';
import { CalendarModule, DateAdapter } from 'angular-calendar';
import { adapterFactory } from 'angular-calendar/date-adapters/date-fns';

import { ChatBoxComponent } from './chat-box/chat-box.component';
import { ContactsComponent } from './contacts/contacts.component';
import { EmailappComponent } from './emailapp/emailapp.component';
import { EmailReadComponent } from './emailapp/email-read/email-read.component';
import { FileManagerComponent } from './file-manager/file-manager.component';
import { FullcalendarComponent } from './fullcalendar/fullcalendar.component';
import { DateTimePickerComponent } from './fullcalendar/date-time-picker.component';
import { InvoiceComponent } from './invoice/invoice.component';



@NgModule({
  declarations: [
    ChatBoxComponent,
    ContactsComponent,
    EmailappComponent,
    EmailReadComponent,
    FileManagerComponent,
    InvoiceComponent,
    FullcalendarComponent,
    DateTimePickerComponent
  ],
  imports: [
    CommonModule,
    ApplicationRoutingModule,
    PerfectScrollbarModule,
      CalendarModule.forRoot({
        provide: DateAdapter,
        useFactory: adapterFactory
      }),
    NgbModalModule,
    NgbDatepickerModule,
    NgbTimepickerModule,
    FormsModule,
  ]
})
export class ApplicationModule { }
