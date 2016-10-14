package app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import app.service.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	private  static final String ADM_ROLE = "ADM";
	private  static final String USER_ROLE = "USER";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.httpBasic()
		.and()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/").permitAll()
				.antMatchers(HttpMethod.GET, "/stats").permitAll()
				
				.antMatchers(HttpMethod.GET, "/problem").permitAll()
				.antMatchers(HttpMethod.POST, "/problem").hasAnyAuthority(ADM_ROLE)
				.antMatchers(HttpMethod.PUT, "/problem").hasAnyAuthority(ADM_ROLE)
				.antMatchers(HttpMethod.PATCH, "/problem").hasAnyAuthority(ADM_ROLE)
				
				.antMatchers(HttpMethod.GET, "/user").hasAnyAuthority(ADM_ROLE)
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.antMatchers(HttpMethod.GET, "/user/{id}").hasAnyAuthority(ADM_ROLE)
				.antMatchers(HttpMethod.PUT, "/user/{id}").hasAnyAuthority(USER_ROLE)
				
				.antMatchers(HttpMethod.GET, "/problem/{id}").permitAll()
				.antMatchers(HttpMethod.GET, "/problem/{id}/solution").hasAnyAuthority(USER_ROLE)
				.antMatchers(HttpMethod.POST, "/problem/{id}/solution").hasAnyAuthority(ADM_ROLE)
				.antMatchers(HttpMethod.PUT, "/problem/{id}/solution").hasAnyAuthority(ADM_ROLE)
				.antMatchers(HttpMethod.PATCH, "/problem/{id}/solution").hasAnyAuthority(ADM_ROLE)
				
				.anyRequest().authenticated()
		.and()
			.csrf()
				.disable();
		
		http.headers().frameOptions().disable();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("senha").roles(ADM_ROLE);
        auth.userDetailsService(userDetailsService());
    }
	
	@Bean
	protected UserDetailsService userDetailsService(){
		return new UserDetailsService() {
			
			@Autowired
			UserRepository userRepo;
			
			@Override
			public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
				app.model.User user = (app.model.User) userRepo.findByEmail(email);
				if (user != null){
					if (user.getType() == "ADM"){
						return new User(user.getEmail(), user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(ADM_ROLE));
					}else{
						return new User(user.getEmail(), user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList(USER_ROLE));
					}
				}else{
					throw new UsernameNotFoundException("Email not found");
				}
			}
		};
	}

}
