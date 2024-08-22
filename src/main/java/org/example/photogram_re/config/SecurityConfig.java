package org.example.photogram_re.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // IoC
@EnableWebSecurity // 해당 파일로 시큐리티 활성화
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorizeRequests) -> // 인증, 인가 설정
                        authorizeRequests
                                .requestMatchers("/", "/user/**", "/image/**", "/subscribe/**", "/comment/**", "/api/**").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin((formLogin) -> // 폼 기반 로그인 설정
                        formLogin
                                .loginPage("/auth/signin") // get
                                .loginProcessingUrl("/auth/signin") // post -> 스프링 시큐리티가 로그인 프로세스 진행
                                .defaultSuccessUrl("/")
                )
                .build();
    }
}
