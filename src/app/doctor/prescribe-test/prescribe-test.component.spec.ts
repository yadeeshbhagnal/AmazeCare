import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrescribeTestComponent } from './prescribe-test.component';

describe('PrescribeTestComponent', () => {
  let component: PrescribeTestComponent;
  let fixture: ComponentFixture<PrescribeTestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrescribeTestComponent]
    });
    fixture = TestBed.createComponent(PrescribeTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
