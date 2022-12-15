import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EncadrantComponent } from './encadrant.component';

describe('EncadrantComponent', () => {
  let component: EncadrantComponent;
  let fixture: ComponentFixture<EncadrantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EncadrantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EncadrantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
