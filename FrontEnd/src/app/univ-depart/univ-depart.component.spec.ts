import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnivDepartComponent } from './univ-depart.component';

describe('UnivDepartComponent', () => {
  let component: UnivDepartComponent;
  let fixture: ComponentFixture<UnivDepartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnivDepartComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UnivDepartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
