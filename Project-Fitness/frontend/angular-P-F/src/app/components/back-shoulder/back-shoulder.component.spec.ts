import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BackShoulderComponent } from './back-shoulder.component';

describe('BackShoulderComponent', () => {
  let component: BackShoulderComponent;
  let fixture: ComponentFixture<BackShoulderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BackShoulderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BackShoulderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
