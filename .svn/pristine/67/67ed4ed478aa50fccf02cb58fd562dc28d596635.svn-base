package basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
      /*
                 返回的Docket交给Spring管理
       */
      @Bean
      public Docket createRestApi() {
          return new Docket(DocumentationType.SWAGGER_2)
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("com.dev.warehouse")) //指定提供接口所在的基包
                  .paths(PathSelectors.any())
                  .build();
      }
      /**
       * 该套 API 说明
       * @return
       */
      private ApiInfo apiInfo() {
          return new ApiInfoBuilder()
                  .title("龟龟网API开发文档")
                  .contact(
                		  new Contact("NetWisdom株式会社", "https://netwisdom.co.jp", "info@netwisdom.co.jp"))
                  .version("1.0.0")
                  .description("欢迎来到龟龟网API开发文档")
                  .build();
      }
}