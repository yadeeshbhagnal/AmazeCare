import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescribeMedicineComponent } from './prescribe-medicine.component';

describe('PrescribeMedicineComponent', () => {
  let component: PrescribeMedicineComponent;
  let fixture: ComponentFixture<PrescribeMedicineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrescribeMedicineComponent]
    });
    fixture = TestBed.createComponent(PrescribeMedicineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
