package com.lk.interview.spring.feignRepeat;

/**
 * @FeignClient 只配置name的情况下，如果有两个以上类重复，就会导致spring注册重复，服务启动报错：AuthRemoteService、AuthRemoteService2。
 * 如果实在有需要同一个微服务多个类文件，可像UserRemoteService、UserRemoteService2一样，配置value、contextId。
 * contextId类似别名，这样spring注册阶段不会报错，微服务名实际还是以value为准。
 * 另外，在只配置name的情况下，value的取值就是name。
 */
public class A {
}
