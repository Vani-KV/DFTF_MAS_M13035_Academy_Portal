import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FacutlylistComponent } from './facutlylist.component';

describe('FacutlylistComponent', () => {
  let component: FacutlylistComponent;
  let fixture: ComponentFixture<FacutlylistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FacutlylistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FacutlylistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
