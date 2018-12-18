package com.th.controller;

import com.th.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianh on 2018/11/26.
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = true,defaultValue = "天虎") String name) {
        return ribbonService.hi(name);
    }

    @GetMapping("testRibbon")
    public String testRibbon() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        return serviceInstance.getHost()+ ":" + serviceInstance.getPort();
    }
}
