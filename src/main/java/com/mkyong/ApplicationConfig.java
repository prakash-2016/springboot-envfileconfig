package com.mkyong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;

@Configuration
//@PropertySource(name = "props" ,value = "file:${MY_PROP}/mail.properties")
public class ApplicationConfig {
	
	private ResourceLoader resourceLoader;
	
	@Value("${MY_PROP}") 
	String envVar;
	
	@Bean(name = "mailfile")
	public PropertiesFactoryBean mapper() {
	    PropertiesFactoryBean mailfile = new PropertiesFactoryBean();
	    mailfile.setFileEncoding("UTF-8");
	    System.out.println("envVar======================================="+envVar);
	    mailfile.setLocation(new FileSystemResource(envVar+"\\mail.properties"));
	    return mailfile;
	}

}
