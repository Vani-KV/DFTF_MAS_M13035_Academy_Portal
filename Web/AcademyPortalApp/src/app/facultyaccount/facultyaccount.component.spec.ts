import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacultyaccountComponent } from './facultyaccount.component';

describe('FacultyaccountComponent', () => {
  let component: FacultyaccountComponent;
  let fixture: ComponentFixture<FacultyaccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacultyaccountComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacultyaccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
