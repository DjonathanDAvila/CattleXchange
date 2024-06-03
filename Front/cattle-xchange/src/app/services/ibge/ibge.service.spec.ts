import { TestBed } from '@angular/core/testing';

import { IbgeService } from './ibge.service';

describe('IbgeService', () => {
  let service: IbgeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IbgeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
