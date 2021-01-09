import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeamsInfoComponent } from './teams-info.component';

describe('TeamsInfoComponent', () => {
  let component: TeamsInfoComponent;
  let fixture: ComponentFixture<TeamsInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeamsInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeamsInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
