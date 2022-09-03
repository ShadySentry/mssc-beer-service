package guru.springframework.msscbeerservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthenticationInterceptor(@Value("${sfg.brewery.inventoryUser}") String inventoryUser,
                                                                      @Value("${sfg.brewery.inventoryPassword}") String inventoryPassword) {
        return new BasicAuthRequestInterceptor(inventoryUser, inventoryPassword);
    }
}
