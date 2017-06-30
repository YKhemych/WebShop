package jv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Created by user on 29.06.2017.
 */

@Configuration
@EnableWebSecurity
public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
}
