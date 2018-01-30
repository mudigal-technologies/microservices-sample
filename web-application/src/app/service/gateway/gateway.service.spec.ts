import { TestBed, inject } from '@angular/core/testing';

import { GatewayService } from './gateway.service';

describe('GatewayService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GatewayService]
    });
  });

  it('should be created', inject([GatewayService], (service: GatewayService) => {
    expect(service).toBeTruthy();
  }));
});
