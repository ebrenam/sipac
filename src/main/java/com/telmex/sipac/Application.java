package com.telmex.sipac;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;
import com.telmex.sipac.backend.CustomerRepository;
import com.telmex.sipac.backend.data.entity.Customer;

@ComponentScan   
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer  {

   private static final Logger log = LoggerFactory.getLogger(Application.class);
	
   public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
   }

   @Override
   protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
      return builder.sources(Application.class);
   }
}
