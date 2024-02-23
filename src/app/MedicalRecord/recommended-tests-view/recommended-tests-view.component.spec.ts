import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RecommendedTestsViewComponent } from './recommended-tests-view.component';

describe('RecommendedTestsViewComponent', () => {
  let component: RecommendedTestsViewComponent;
  let fixture: ComponentFixture<RecommendedTestsViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RecommendedTestsViewComponent]
    });
    fixture = TestBed.createComponent(RecommendedTestsViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
