package vn.cmctelecom.scheduler.config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.cmctelecom.scheduler.enitiy.dto.UserDetail;
import vn.cmctelecom.scheduler.service.impl.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckKeycloak extends OncePerRequestFilter {
    @Autowired
   private AuthenticationManager authenticate;

    @Autowired
    private  Gson gson;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("ccc");
        try {
            UserServiceImpl userService = new UserServiceImpl();
            request.setAttribute("Author", request.getHeader("Authorization"));
            String token = request.getHeader("Authorization");
            StringBuffer userJson = new StringBuffer();
            if (userService.validateToken(token,userJson)) {
                JsonElement jsonElement = gson.fromJson(userJson.toString(),JsonElement.class);
                UserDetail userDetail= new UserDetail(jsonElement);
                UsernamePasswordAuthenticationToken authentication
                		= new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }

        filterChain.doFilter(request,response);
    }
}
