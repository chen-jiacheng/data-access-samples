package com.chenjiacheng.data.access.samples.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenjiacheng on 2025/6/1 18:40
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@RestController
@RequestMapping("/health")
public class HealthyCheckController {

    @RequestMapping("/check")
    public String checkHealth() {
        return "I'm fine!";
    }

}
