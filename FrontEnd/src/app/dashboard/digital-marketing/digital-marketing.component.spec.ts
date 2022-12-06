import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DigitalMarketingComponent } from './digital-marketing.component';

describe('DigitalMarketingComponent', () => {
  let component: DigitalMarketingComponent;
  let fixture: ComponentFixture<DigitalMarketingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DigitalMarketingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DigitalMarketingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
