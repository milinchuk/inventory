package inventory.service.config;

import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegrationManagement;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@EnableIntegrationManagement
@ImportResource("classpath:inventory-service-rest-endpoints.xml")
public class Application extends SpringBootServletInitializer {

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }
}