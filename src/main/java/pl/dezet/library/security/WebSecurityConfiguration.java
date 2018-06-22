package pl.dezet.library.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.dezet.library.model.User;
import pl.dezet.library.model.UserLoginType;
import pl.dezet.library.repository.UserRepository;

import java.time.LocalDateTime;


@Configurable
@EnableOAuth2Sso
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebSecurityConfiguration.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/js/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String principalId = (String) map.get("id");
            User user = userRepository.findByPrincipalId(principalId);
            if (user == null) {
                LOGGER.info("No user found, generating profile for {}", principalId);
                user = new User();
                user.setPrincipalId(principalId);
                user.setCreated(LocalDateTime.now());
                user.setEmail((String) map.get("email"));
                user.setFullName((String) map.get("name"));
                user.setPhoto((String) map.get("picture"));
                user.setLoginType(UserLoginType.GOOGLE);
                user.setLastLogin(LocalDateTime.now());
            } else {
                user.setLastLogin(LocalDateTime.now());
            }
            userRepository.save(user);
            return user;
        };
    }

}
