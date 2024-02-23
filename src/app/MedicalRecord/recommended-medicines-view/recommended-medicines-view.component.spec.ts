import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendedMedicinesViewComponent } from './recommended-medicines-view.component';

describe('RecommendedMedicinesViewComponent', () => {
  let component: RecommendedMedicinesViewComponent;
  let fixture: ComponentFixture<RecommendedMedicinesViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecommendedMedicinesViewComponent]
    });
    fixture = TestBed.createComponent(RecommendedMedicinesViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
