/*package com.springboot.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@EnableAuthorizationServer
@Configuration
public class AuthServer extends AuthorizationServerConfigurerAdapter {

	@Autowired
	AuthenticationManager manager;

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// share authentication manager. So user logged in as root, will be known by
		// authorization server
		endpoints.authenticationManager(manager);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		// Resource grant type
		// resourceId will link us to the resource server
		clients.inMemory().withClient("client").secret("{noop}secret").authorizedGrantTypes("password")
				.resourceIds("oauth2-resource").scopes("read");
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.addTokenEndpointAuthenticationFilter(new CorsFilter());
	}

	public static class CorsFilter implements Filter {

		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
				throws IOException, ServletException {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
			resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
			resp.addHeader("Access-Control-Max-Age", "3600");
			resp.addHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
			//allow headers to be sent to the server
			resp.addHeader("Access-Control-Expose-Headers", "*");
			//headers to be consumed
			resp.addHeader("Access-Control-Allow-Credentials", "true");
			
			if(req.getMethod().equalsIgnoreCase("Options")){
				resp.setStatus(200);
			}else {
				chain.doFilter(req, resp);
			}
		}

	}
}
*/