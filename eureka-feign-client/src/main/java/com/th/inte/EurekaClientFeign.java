package com.th.inte;

import com.th.inte.impl.HiHystrix;
import com.th.vo.FeignConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tianh on 2018/11/26.
 */
@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeign {

    @GetMapping("/hi")
    String sayHi(@RequestParam(value = "name") String name);
}
