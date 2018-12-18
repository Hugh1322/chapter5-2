package com.th.inte.impl;

import com.th.inte.EurekaClientFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tianh on 2018/11/27.
 */
@Component
public class HiHystrix implements EurekaClientFeign{
    @Override
    public String sayHi(@RequestParam(value = "name") String name) {
        return "hi," + name + ",sorry,error!";
    }
}
