import { TestBed } from '@angular/core/testing';

import { EventBusServiceTsService } from './event-bus.service.ts.service';

describe('EventBusServiceTsService', () => {
  let service: EventBusServiceTsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EventBusServiceTsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
