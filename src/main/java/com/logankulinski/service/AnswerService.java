package com.logankulinski.service;

import org.springframework.ai.openai.client.OpenAiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public final class AnswerService {
    private final OpenAiClient client;

    @Autowired
    public AnswerService(OpenAiClient client) {
        Objects.requireNonNull(client);

        this.client = client;
    }

    public String getAnswer(String prompt) {
        return this.client.generate(prompt);
    }
}
