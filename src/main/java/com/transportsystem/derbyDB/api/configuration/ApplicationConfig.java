package com.transportsystem.derbyDB.api.configuration;

import com.transportsystem.derbyDB.api.service.DBService;
import com.transportsystem.derbyDB.api.utility.ExcelRead;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * The type Application config.
 */
@Setter
@Getter
@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

   @Value("${application.data}")
   private String filename;

    @Autowired
    private DBService DBService;

    /**
     * On application event.
     *
     * @param event the event
     */
    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        ExcelRead excelRead = new ExcelRead(filename);

        try {
            FileInputStream fis = new FileInputStream(filename);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            DBService.savePlanetData(excelRead.readPlanetData(workbook.getSheetAt(0)));
            DBService.saveRoutsData(excelRead.readRoutesData(workbook.getSheetAt(1)));
            DBService.saveTrafficData(excelRead.readTrafficData(workbook.getSheetAt(2)));
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Custom open api open api.
     *
     * @return the open api
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Derby DB API").description(
                        "Spring Boot based rest api service for transport system to connect with Database")
                        .version("v1"));
    }

    /**
     * Cors filter filter registration bean.
     *
     * @return the filter registration bean
     */
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

}

