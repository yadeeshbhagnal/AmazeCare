import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewUpcomingAppointmentsComponent } from './view-upcoming-appointments.component';

describe('ViewUpcomingAppointmentsComponent', () => {
  let component: ViewUpcomingAppointmentsComponent;
  let fixture: ComponentFixture<ViewUpcomingAppointmentsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ViewUpcomingAppointmentsComponent]
    });
    fixture = TestBed.createComponent(ViewUpcomingAppointmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
