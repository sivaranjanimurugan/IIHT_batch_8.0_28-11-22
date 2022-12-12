package com.token.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.token.services.UserService;
import com.token.utility.JWTUtility;

@Component
public class JWTFilter extends OncePerRequestFilter {

	@Autowired
	private JWTUtility jwtUtil;

	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorization = request.getHeader("Authorization");
		String token = null;
		String username = null;
		
		if(authorization != null && authorization.startsWith("Bearer ")) {
			 System.out.println("token::"+authorization);
		    token = authorization.substring(7);
		    System.out.println("token:::"+token);
		    username = jwtUtil.getUsernameFromToken(token);
		}
		
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userService.loadUserByUsername(username);
			
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePwdAuthToken = new UsernamePasswordAuthenticationToken(
						userDetails, userDetails.getAuthorities());
				usernamePwdAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePwdAuthToken);
			};
		}
		filterChain.doFilter(request, response);

	}

}
