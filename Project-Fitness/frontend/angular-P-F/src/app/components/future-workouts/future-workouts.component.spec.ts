import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FutureWorkoutsComponent } from './future-workouts.component';

describe('FutureWorkoutsComponent', () => {
  let component: FutureWorkoutsComponent;
  let fixture: ComponentFixture<FutureWorkoutsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FutureWorkoutsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FutureWorkoutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
