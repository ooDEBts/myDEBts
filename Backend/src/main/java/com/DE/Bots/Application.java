/**
 * 
 */
package com.DE.Bots;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.DE.Bots.Config.DataConfig;
import com.DE.Bots.Config.RestApiConfig;
import com.DE.Bots.Config.WebMVCConfig;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class, RestApiConfig.class, WebMVCConfig.class, DataConfig.class);
    }

    public static void main(String[] args) {
        new Application().configure(new SpringApplicationBuilder(Application.class)).run(args);
    }
}
