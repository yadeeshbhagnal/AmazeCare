import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTestResultComponent } from './update-test-result.component';

describe('UpdateTestResultComponent', () => {
  let component: UpdateTestResultComponent;
  let fixture: ComponentFixture<UpdateTestResultComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateTestResultComponent]
    });
    fixture = TestBed.createComponent(UpdateTestResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
