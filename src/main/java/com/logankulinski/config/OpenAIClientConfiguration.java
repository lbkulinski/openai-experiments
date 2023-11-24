package com.logankulinski.config;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.core.credential.KeyCredential;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class OpenAIClientConfiguration {
    @Bean
    public OpenAIClient openAIClient(@Value("${openai.api-key}") String apiKey) {
        Objects.requireNonNull(apiKey);

        KeyCredential keyCredential = new KeyCredential(apiKey);

        return new OpenAIClientBuilder()
            .credential(keyCredential)
            .buildClient();
    }
}
