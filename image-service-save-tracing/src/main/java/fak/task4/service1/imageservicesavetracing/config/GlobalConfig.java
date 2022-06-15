package fak.task4.service1.imageservicesavetracing.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfig {

    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }

}