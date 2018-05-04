package com.DE.Bots.Config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.bolt.license.api")

public class WebMVCConfig extends WebMvcConfigurerAdapter{
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable("api");
	    }

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        MappingJackson2HttpMessageConverter jackson = new MappingJackson2HttpMessageConverter();
	        jackson.setObjectMapper(new CustomObjectMapper());
	        jackson.getObjectMapper().disable(SerializationFeature.WRITE_NULL_MAP_VALUES)
	                .enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING)
	                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        converters.add(jackson);
	    }
}
