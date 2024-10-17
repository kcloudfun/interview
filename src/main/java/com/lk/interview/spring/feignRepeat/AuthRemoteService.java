package com.lk.interview.spring.feignRepeat;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "auth")
public interface AuthRemoteService {
}
