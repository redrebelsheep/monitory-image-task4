package de.fak.editpicture;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EditpictureApplication {

	public static void main(String[] args) {
		SpringApplication.run(EditpictureApplication.class, args);
	}

	@Bean
	public OpenTelemetry opentelemetry(){
		return GlobalOpenTelemetry.get();
	}

}
