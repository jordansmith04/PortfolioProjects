import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutsComponent } from './workouts.component';
import { AppComponent } from 'src/app/app.component';
import { RouterTestingModule } from '@angular/router/testing';
import { RouterLinkWithHref } from '@angular/router';
import { By } from 'protractor';
describe('WorkoutsComponent', () => {
  let component: WorkoutsComponent;
  let fixture: ComponentFixture<WorkoutsComponent>;
  let element: HTMLElement;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkoutsComponent ],
      imports: [RouterTestingModule.withRoutes([])],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkoutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  

});
