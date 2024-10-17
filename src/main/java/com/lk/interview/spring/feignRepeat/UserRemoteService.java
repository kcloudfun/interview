package com.lk.interview.spring.feignRepeat;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "user",contextId = "user1")
public interface UserRemoteService {
}
