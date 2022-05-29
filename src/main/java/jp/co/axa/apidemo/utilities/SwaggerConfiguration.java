package jp.co.axa.apidemo.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo(
                        "Java Challenge",
                        "Sample API with JWT Authentication and Cache",
                        "1",
                        "",
                        "Sihan",
                        "MIT",
                        "")
                ).select()
                .apis(RequestHandlerSelectors.basePackage("jp.co.axa.apidemo.controllers"))
                .build();
    }
}