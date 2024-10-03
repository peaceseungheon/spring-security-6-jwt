package kr.co.sh.spring_security6_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringSecurity6JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity6JwtApplication.class, args);
	}

}
