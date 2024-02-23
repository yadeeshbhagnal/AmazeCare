import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DoctorRegisterComponent } from './admin/doctor-register/doctor-register.component';
import { AssignAppointmentComponent } from './admin/assign-appointment/assign-appointment.component';
import { DeleteComponent } from './admin/delete/delete.component';
import { DocByNameComponent } from './admin/doc-by-name/doc-by-name.component';
import { UpdateDoctorDetailsComponent } from './admin/update-doctor-details/update-doctor-details.component';
import { ViewAllAppointmentsComponent } from './admin/view-all-appointments/view-all-appointments.component';
import { ViewDoctorsComponent } from './admin/view-doctors/view-doctors.component';
import { ViewPatientsComponent } from './admin/view-patients/view-patients.component';
import { ViewUpcomingAppointmentsComponent } from './admin/view-upcoming-appointments/view-upcoming-appointments.component';
import { AddMedicineComponent } from './admin/add-medicine/add-medicine.component';
import { AddTestComponent } from './admin/add-test/add-test.component';
import { AdminDashboardComponent } from './admin/admin-dashboard/admin-dashboard.component';
import { AdminRegisterComponent } from './admin/admin-register/admin-register.component';
import { MedicalRecordViewComponent } from './MedicalRecord/medical-record-view/medical-record-view.component';
import { PatientMedicalRecordViewComponent } from './MedicalRecord/patient-medical-record-view/patient-medical-record-view.component';
import { RecommendedMedicinesViewComponent } from './MedicalRecord/recommended-medicines-view/recommended-medicines-view.component';
import { RecommendedTestsViewComponent } from './MedicalRecord/recommended-tests-view/recommended-tests-view.component';


const routes: Routes = [
  {path: 'doctor-registeration', component: DoctorRegisterComponent},
  {path: 'add-medicine', component: AddMedicineComponent},
  {path: 'add-test', component: AddTestComponent},
  {path: 'admin-dashboard', component: AdminDashboardComponent},
  {path: 'admin-register', component: AdminRegisterComponent},
  {path: 'assign-appointment', component: AssignAppointmentComponent},
  {path: 'delete', component: DeleteComponent},
  {path: 'doc-by-name', component: DocByNameComponent},
  {path: 'doctor-register', component: DoctorRegisterComponent},
  {path: 'update-doctor-details', component: UpdateDoctorDetailsComponent},
  {path: 'view-all-appointments', component: ViewAllAppointmentsComponent},
  {path: 'view-doctors', component: ViewDoctorsComponent},
  {path: 'view-patients', component: ViewPatientsComponent},
  {path: 'view-upcoming-appointments', component: ViewUpcomingAppointmentsComponent},

  {path: 'medical-record-view', component: MedicalRecordViewComponent},
  {path: 'patient-medical-record-view', component: PatientMedicalRecordViewComponent},
  {path: 'recommended-medicine-view', component: RecommendedMedicinesViewComponent},
  {path: 'recommended-tests-view', component: RecommendedTestsViewComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
