import { async, ComponentFixture, TestBed, fakeAsync } from '@angular/core/testing';

import { ChestArmsComponent } from './chest-arms.component';
import { element, by } from 'protractor';

describe('ChestArmsComponent', () => {
  let component: ChestArmsComponent;
  let fixture: ComponentFixture<ChestArmsComponent>;
  let element: HTMLElement;
  

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [],
      declarations: [ ChestArmsComponent ],
      providers: [],

      
    })
    .compileComponents()
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChestArmsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
   
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should display the `example workout` button',() => {
    expect(element.innerText).toContain('example workout');
  });

})
