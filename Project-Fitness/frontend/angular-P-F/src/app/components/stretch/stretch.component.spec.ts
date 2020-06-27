import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { element, By, by, browser } from 'protractor';
import { StretchComponent} from './stretch.component';

describe('StretchComponent', () => {
  let component: StretchComponent;
  let element: HTMLElement;
  let fixture: ComponentFixture<StretchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StretchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StretchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it ('Should not display the modal unless the button is clicked',() =>{
    expect(element.innerText).toContain("example");
  
  ///expect(component.showModal).toBeFalsy("Show modal should be initially false");
  });
  
});
