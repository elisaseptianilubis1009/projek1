package com.tugasakhir.projek1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class KonfigurasiSecurity extends WebSecurityConfigurerAdapter{
	
	private static final String SQL_LOGIN = "SELECT username, PASSWORD,active as enabled  FROM login WHERE username = ?" ;
	
	private static final String SQL_PERMISSION ="SELECT username,akses AS authority FROM login  WHERE username = ?";
	
	@Autowired 
	private DataSource sd;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		
//		setting security non database
        /*auth
                .inMemoryAuthentication()
                .withUser("ciazhar")
                .password("123")
                .roles("apa");-->*/
		
//		setting java dengan database
		.jdbcAuthentication()
		.dataSource(sd)
		.usersByUsernameQuery(SQL_LOGIN)
		.authoritiesByUsernameQuery(SQL_PERMISSION);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}	
	//INI TUH HANYA BUAT HAK AKSES DOANG
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	        .antMatchers("/admin/tampil").hasAnyAuthority("ADMIN")
	        .antMatchers("/index").hasAnyAuthority("ADMIN")
	        .antMatchers("/admin/create").hasAuthority("ADMIN")
	        .antMatchers("/pembeli/tampil").hasAuthority("ADMIN")
	       .antMatchers("/detail/tampil").hasAuthority("ADMIN")
	        .antMatchers("/").hasAnyAuthority("ADMIN","PEMILIK","PEMBELI")
	        .antMatchers("/cart/save").hasAnyAuthority("ADMIN","PEMBELI","PEMILIK")
	        .antMatchers("/cart/tampil").hasAnyAuthority("PEMBELI","ADMIN")
	        .antMatchers("/shop/tampil").hasAnyAuthority("ADMIN","PEMBELI","PEMILIK")
	        .antMatchers("/login").hasAnyAuthority("ADMIN","PEMBELI","PEMILIK")
	        
	        //AKUN
	        .antMatchers("/akun/edit/{id}/{idLogin}").hasAuthority("PEMBELI")
	        .antMatchers("/registrasi/update").hasAuthority("PEMBELI")
	        
	       
	        //KHUSUS DASBOARD ADMIN
	        
	        //ADMIN
	        .antMatchers("/admin/tampil").hasAuthority("ADMIN")
	        .antMatchers("/admin/create").hasAuthority("ADMIN")
	        .antMatchers("/admin/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/admin/delete/{id}").hasAuthority("ADMIN")
	        
	        //RASA
	        .antMatchers("/rasa/tampil").hasAuthority("ADMIN")
	        .antMatchers("/rasa/create").hasAuthority("ADMIN")
	        .antMatchers("/rasa/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/rasa/delete/{id}").hasAuthority("ADMIN")
	        
	        //UKURAN
	        .antMatchers("/ukuran/tampil").hasAuthority("ADMIN")
	        .antMatchers("/ukuran/create").hasAuthority("ADMIN")
	        .antMatchers("/ukuran/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/ukuran/delete/{id}").hasAuthority("ADMIN")
     
	        //PRODUK
	        .antMatchers("/produk/tampil").hasAuthority("ADMIN")
	        .antMatchers("/produk/create").hasAuthority("ADMIN")
	        .antMatchers("/produk/edit/{id}").hasAuthority("ADMIN")
	        .antMatchers("/produk/delete/{id}").hasAuthority("ADMIN")
	        
	        
	        
//	        .anyRequest().authenticated()
	        .and() 
	        .formLogin()
	        .loginPage("/login").permitAll()
	        //.defaultSuccessUrl("/mahasiswa")
	        .and()
	        .logout();
	    
	        
	}


}
