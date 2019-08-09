package com.verizon.productcatalog.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class ProductCatalogSecurityConfig extends WebSecurityConfigurerAdapter{
@Override
public void configure(AuthenticationManagerBuilder builder) throws Exception {
	builder.inMemoryAuthentication().withUser("saturday").password("{noop}slither").roles("USER").and()
	.withUser("abcde").password("{noop}xyz123").roles("USER","ADMIN");
}
@Override
public void configure(HttpSecurity security) throws Exception
{
	security.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	security.csrf().disable();
}
}
