package arq.soft.arqSoft1.interceptor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import arq.soft.arqSoft1.dao.TransaccionDAO;

@Component
public class ComprasInterceptor implements HandlerInterceptor {
	
	@Autowired
	private TransaccionDAO transaccionDAO;
	
	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	      
	      return true;
	   }
	
	   @Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {}
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {
		   
		  try {

			  String uri = request.getRequestURI();
			  if("/ventaProductos".equals(uri)) {
				  String codigo = "00";
				  if(exception != null) {
					  codigo = "99";
				  }
				  
				  //String result = new BufferedReader(new InputStreamReader(request.getInputStream()))
				  //		   .lines().collect(Collectors.joining("\n"));
			  }
			  
		  }catch(Exception e) {
			  //Fallo el registro de la transaccion
		  }
	   }

	public TransaccionDAO getTransaccionDAO() {
		return transaccionDAO;
	}

	public void setTransaccionDAO(TransaccionDAO transaccionDAO) {
		this.transaccionDAO = transaccionDAO;
	}

}
