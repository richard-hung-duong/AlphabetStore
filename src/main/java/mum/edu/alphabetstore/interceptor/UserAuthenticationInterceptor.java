package mum.edu.alphabetstore.interceptor;

import mum.edu.alphabetstore.domain.Customer;
import mum.edu.alphabetstore.domain.User;
import mum.edu.alphabetstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAuthenticationInterceptor extends HandlerInterceptorAdapter {

	
@Autowired
UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		org.springframework.security.core.userdetails.User  userSec = (org.springframework.security.core.userdetails.User )SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if(userSec.getUsername()==null){
        	 return false;
         }
        
         User user =  userService.getUserByUsername(userSec.getUsername());
		
         if(user!=null){
		Customer customer = new Customer();
		customer.setCustomerId(user.getId());
		customer.setName(user.getFirstName()+" "+user.getLastName());
		customer.setBillingAddress(user.getAddresse());
		customer.setPhoneNumber(user.getPhoneNumber());
		request.setAttribute("customer", customer);
		return true;
		}
		
		return false;
	}
}
