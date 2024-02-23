import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocByNameComponent } from './doc-by-name.component';

describe('DocByNameComponent', () => {
  let component: DocByNameComponent;
  let fixture: ComponentFixture<DocByNameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DocByNameComponent]
    });
    fixture = TestBed.createComponent(DocByNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
