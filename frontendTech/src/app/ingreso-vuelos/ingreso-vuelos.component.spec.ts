import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IngresoVuelosComponent } from './ingreso-vuelos.component';

describe('IngresoVuelosComponent', () => {
  let component: IngresoVuelosComponent;
  let fixture: ComponentFixture<IngresoVuelosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IngresoVuelosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IngresoVuelosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
