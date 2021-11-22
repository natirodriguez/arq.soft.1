package arq.soft.arqSoft1.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ComprasInterceptorAppConfig extends WebMvcConfigurerAdapter {

	
	   @Autowired
	   ComprasInterceptor comprasInterceptor;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(comprasInterceptor);
	   }
}
