package com.utfpr.bd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Component 
@EnableJpaAuditing
public class SpringAutditingConfig{
   @Bean
   public AuditorAware<String> auditorAware() {
      return new SpringSecurityAduitorAware();
   }
}
