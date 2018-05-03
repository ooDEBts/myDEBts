package com.DE.Bots.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestController;

@Order(1)
@Configuration
@ComponentScan(excludeFilters = { @ComponentScan.Filter(RestController.class), }, basePackages = "com.bolt.license")

public class RestApiConfig {

}
