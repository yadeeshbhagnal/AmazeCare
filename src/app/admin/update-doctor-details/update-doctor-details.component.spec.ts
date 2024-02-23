import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDoctorDetailsComponent } from './update-doctor-details.component';

describe('UpdateDoctorDetailsComponent', () => {
  let component: UpdateDoctorDetailsComponent;
  let fixture: ComponentFixture<UpdateDoctorDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateDoctorDetailsComponent]
    });
    fixture = TestBed.createComponent(UpdateDoctorDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
