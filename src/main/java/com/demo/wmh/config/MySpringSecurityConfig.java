package com.demo.wmh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.formLogin()
              /*.loginPage("/login.html")*/
              .loginProcessingUrl("/login/toLogin")
              .defaultSuccessUrl("/login/hello").permitAll()
              .and()
              .authorizeRequests().antMatchers("/login/toLogin").permitAll()
              .anyRequest().authenticated()
              .and()
              .csrf().disable();//关闭csrf保护

    }
    @Autowired
    private UserDetailsService userDetailsServicel;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //方式一：固定用户名
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String password=bCryptPasswordEncoder.encode("wmh");
//        auth.inMemoryAuthentication().withUser("wmh").password(password).roles("admin");
        //方式二：自己定义配置类实现
        auth.userDetailsService(userDetailsServicel).passwordEncoder(getPasswordEncoder());
    }
    //初始化BCryptPasswordEncoder类
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }

}
