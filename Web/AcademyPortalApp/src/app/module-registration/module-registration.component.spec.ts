import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModuleRegistrationComponent } from './module-registration.component';

describe('ModuleRegistrationComponent', () => {
  let component: ModuleRegistrationComponent;
  let fixture: ComponentFixture<ModuleRegistrationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModuleRegistrationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ModuleRegistrationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
