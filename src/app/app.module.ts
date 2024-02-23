import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminRegisterComponent } from './admin/admin-register/admin-register.component';
import { DoctorRegisterComponent } from './admin/doctor-register/doctor-register.component';
import { AdminLoginComponent } from './admin/admin-login/admin-login.component';
import { UpdateDoctorDetailsComponent } from './admin/update-doctor-details/update-doctor-details.component';
import { ViewAllAppointmentsComponent } from './admin/view-all-appointments/view-all-appointments.component';
import { ViewUpcomingAppointmentsComponent } from './admin/view-upcoming-appointments/view-upcoming-appointments.component';
import { ViewDoctorsComponent } from './admin/view-doctors/view-doctors.component';
import { ViewPatientsComponent } from './admin/view-patients/view-patients.component';
import { AssignAppointmentComponent } from './admin/assign-appointment/assign-appointment.component';
import { AddTestComponent } from './admin/add-test/add-test.component';
import { AddMedicineComponent } from './admin/add-medicine/add-medicine.component';
import { DeleteComponent } from './admin/delete/delete.component';
import { DocByNameComponent } from './admin/doc-by-name/doc-by-name.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { DoctorLoginComponent } from './doctor/doctor-login/doctor-login.component';
import { UpcomingAppointmentsComponent } from './doctor/upcoming-appointments/upcoming-appointments.component';
import { AcceptAppointmentsComponent } from './doctor/accept-appointments/accept-appointments.component';
import { RejectAppointmentComponent } from './doctor/reject-appointment/reject-appointment.component';
import { RescheduleAppointmentComponent } from './doctor/reschedule-appointment/reschedule-appointment.component';
import { MedicalRecordComponent } from './doctor/medical-record/medical-record.component';
import { PrescribeMedicineComponent } from './doctor/prescribe-medicine/prescribe-medicine.component';
import { PrescribeTestComponent } from './doctor/prescribe-test/prescribe-test.component';
import { UpdateTestResultComponent } from './doctor/update-test-result/update-test-result.component';
import { DoctorDashboardComponent } from './doctor/doctor-dashboard/doctor-dashboard.component';
import { PatientDashboardComponent } from './patient/patient-dashboard/patient-dashboard.component';
import { PatientLoginComponent } from './patient/patient-login/patient-login.component';
import { PatientRegisterationComponent } from './patient/patient-registeration/patient-registeration.component';
import { ScheduleAppointmentComponent } from './patient/schedule-appointment/schedule-appointment.component';
import { CancelAppointmentComponent } from './patient/cancel-appointment/cancel-appointment.component';
import { AllAppointmentsComponent } from './patient/all-appointments/all-appointments.component';
import { UpdateInfoComponent } from './patient/update-info/update-info.component';
import { SearchDoctorComponent } from './patient/search-doctor/search-doctor.component';
import { MedicalRecordViewComponent } from './MedicalRecord/medical-record-view/medical-record-view.component';
import { PatientMedicalRecordViewComponent } from './MedicalRecord/patient-medical-record-view/patient-medical-record-view.component';
import { RecommendedTestsViewComponent } from './MedicalRecord/recommended-tests-view/recommended-tests-view.component';
import { RecommendedMedicinesViewComponent } from './MedicalRecord/recommended-medicines-view/recommended-medicines-view.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminRegisterComponent,
    DoctorRegisterComponent,
    AdminLoginComponent,
    UpdateDoctorDetailsComponent,
    ViewAllAppointmentsComponent,
    ViewUpcomingAppointmentsComponent,
    ViewDoctorsComponent,
    ViewPatientsComponent,
    AssignAppointmentComponent,
    AddTestComponent,
    AddMedicineComponent,
    DeleteComponent,
    DocByNameComponent,
    AdminDashboardComponent,
    DoctorLoginComponent,
    UpcomingAppointmentsComponent,
    AcceptAppointmentsComponent,
    RejectAppointmentComponent,
    RescheduleAppointmentComponent,
    MedicalRecordComponent,
    PrescribeMedicineComponent,
    PrescribeTestComponent,
    UpdateTestResultComponent,
    DoctorDashboardComponent,
    PatientDashboardComponent,
    PatientLoginComponent,
    PatientRegisterationComponent,
    ScheduleAppointmentComponent,
    CancelAppointmentComponent,
    AllAppointmentsComponent,
    UpdateInfoComponent,
    SearchDoctorComponent,
    MedicalRecordViewComponent,
    PatientMedicalRecordViewComponent,
    RecommendedTestsViewComponent,
    RecommendedMedicinesViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
