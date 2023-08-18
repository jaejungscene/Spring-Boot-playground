package jaejung.springprac.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/user/**").authenticated()
                .requestMatchers("/manager/**").hasAnyRole("admin", "manager")
                .requestMatchers("/admin/**").hasRole("admin")
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/login");
//        http.authorizeHttpRequests((authz)->
//        {
//            try {
//                authz
//                        .requestMatchers("/user/**").authenticated()
//                        .requestMatchers("/manager/**").hasAnyRole("manager", "admin")
//                        .requestMatchers("/admin/**").hasRole("admin")
//                        .anyRequest().permitAll()
//                        .and()
//                        .formLogin()
//                        .loginPage("/login");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
        return http.build();
    }
}
