import { TestBed } from '@angular/core/testing';

import { WithdrawlService } from './withdrawl.service';

describe('WithdrawlService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WithdrawlService = TestBed.get(WithdrawlService);
    expect(service).toBeTruthy();
  });
});
