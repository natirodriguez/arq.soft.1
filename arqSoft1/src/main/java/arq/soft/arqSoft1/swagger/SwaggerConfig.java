package arq.soft.arqSoft1.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/productos.*"), regex("/vendedores.*"), regex("/usuarios.*"), regex("/categorias.*"), regex("/ventaProductos.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("ArquiReSoftware API")
				.description("ArquiReSoftware API reference for developers")
				//.termsOfServiceUrl("http://javainuse.com")
				.contact("marilaumedici@gmail.com").license("Medici License")
				.licenseUrl("marilaumedici@gmail.com").version("1.0").build();
	}

}
