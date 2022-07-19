package com.tienda;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    //El siguiente método funciona para hacer la autenticación del usuario
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication() //Sale en examen los usuarios en bases de datos
                .withUser("admin")
                .password("{noop}123") //No va a encriptar la contraseña {noop} noop debe ser entre {}
                .roles("ADMIN","VENDEDOR","USER")
                .and()
                .withUser("vendedor")
                .password("{noop}123") //No va a encriptar la contraseña {noop} noop debe ser entre {}
                .roles("VENDEDOR","USER")
                .and()
                .withUser("user")
                .password("{noop}123") //No va a encriptar la contraseña {noop} noop debe ser entre {}
                .roles("USER"); //Al puro final de definir usuarios, se pone el ;
                
    }
    //Definir la configuración de los accesos de cada Perfil de usuario
    @Override
    protected void configure(HttpSecurity http)throws Exception {
        http.authorizeRequests()
                .antMatchers("/articulo/nuevo",          "/articulo/guardar",
                             "/articulo/modificar/**",   "articulo/eliminar/**",
                             "/categoria/nuevo",         "/categoria/guardar",
                             "/categoria/modificar/**",  "categoria/eliminar/**",
                             "/cliente/nuevo",           "/cliente/guardar",
                             "/cliente/modificar/**",    "cliente/eliminar/**",
                             "/usuario/nuevo",           "/usuario/guardar",
                             "/usuario/modificar/**",    "usuario/eliminar/**")
                       .hasRole("ADMIN") //Sólo para un usuario
                .antMatchers("/articulo/listado",        "/cliente/listado",
                             "/categoria/listado")
                       .hasAnyRole("ADMIN", "VENDEDOR") //Para varios usuarios
                .antMatchers("/")
                       .hasAnyRole("ADMIN", "VENDEDOR", "USER")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
