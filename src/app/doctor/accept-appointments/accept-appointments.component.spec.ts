import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcceptAppointmentsComponent } from './accept-appointments.component';

describe('AcceptAppointmentsComponent', () => {
  let component: AcceptAppointmentsComponent;
  let fixture: ComponentFixture<AcceptAppointmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcceptAppointmentsComponent]
    });
    fixture = TestBed.createComponent(AcceptAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
