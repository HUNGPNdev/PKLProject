package t3h.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("t3h.project.*")
public class AngularspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularspringbootApplication.class, args);
	}

}
