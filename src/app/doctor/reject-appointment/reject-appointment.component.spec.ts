import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RejectAppointmentComponent } from './reject-appointment.component';

describe('RejectAppointmentComponent', () => {
  let component: RejectAppointmentComponent;
  let fixture: ComponentFixture<RejectAppointmentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RejectAppointmentComponent]
    });
    fixture = TestBed.createComponent(RejectAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
