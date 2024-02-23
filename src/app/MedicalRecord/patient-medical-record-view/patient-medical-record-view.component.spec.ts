import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatientMedicalRecordViewComponent } from './patient-medical-record-view.component';

describe('PatientMedicalRecordViewComponent', () => {
  let component: PatientMedicalRecordViewComponent;
  let fixture: ComponentFixture<PatientMedicalRecordViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PatientMedicalRecordViewComponent]
    });
    fixture = TestBed.createComponent(PatientMedicalRecordViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
