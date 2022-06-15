package fak.task4.service1.imageservicesavetracing;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageServiceSaveTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageServiceSaveTracingApplication.class, args);
	}

	@Bean
	public OpenTelemetry opentelemetry(){
		return GlobalOpenTelemetry.get();
	}
}
