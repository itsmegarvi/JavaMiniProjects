//package com.mis.jparestdemo2;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration
//public class SwaggerConfig {
////    public static final ApiInfo DEFAULT_API_INFO=new ApiInfo("Awesome API SwaggerTitle","Awesome API Description","1.0",
////            "urn:tos","gmailadmin@gmail.com","Apache 2.0","http://www.apache.org/licenses/LICENSE-2.0");
////    public static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES=
////            new HashSet<String>(Arrays.asList("application/json","application/xml"));
//
//
//    @Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//}
