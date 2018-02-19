package com.itay.spring.tutorials.microservices.greeting.ui;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ConfigurationProperties("greeting")
@EnableJpaRepositories
@ComponentScan("com.itay.spring.tutorials.spring.microservices")
@EnableTransactionManagement
@EnableCaching
public class AppConfig {
    
    private @NotNull String welcome;//Any property must have a setter method in order to enable Spring container set from properties file

    private @NotNull  String byeNow;
    
    //This method name must comply with property exact name; if property full name is greeting.byeBye,
    //and we are linked to "greeting", then property name byeBye; therefore setter method name should be:
    //"set" + "[b=B]yeBye" => setByeBye()
    public void setByeBye(String bye) {
        this.byeNow = bye;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    @Bean
    public CacheManager cacheManager() {
	System.out.println(welcome + "...." + byeNow);
	System.out.println("============> ConcurrentMapCacheManager....Building: 'greeting-cache'");
	return new GuavaCacheManager("greeting-cache");
    }
}
