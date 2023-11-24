package com.logankulinski.service;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public final class AnswerService {
    private final String model;

    private final OpenAIClient client;

    @Autowired
    public AnswerService(@Value("${openai.model}") String model, OpenAIClient client) {
        this.model = Objects.requireNonNull(model);

        this.client = Objects.requireNonNull(client);
    }

    public String getAnswer(String prompt) {
        ChatMessage message = new ChatMessage(ChatRole.USER, prompt);

        List<ChatMessage> messages = List.of(message);

        ChatCompletionsOptions options = new ChatCompletionsOptions(messages);

        ChatCompletions completions = this.client.getChatCompletions(this.model, options);

        return completions.getChoices()
                          .getFirst()
                          .getMessage()
                          .getContent();
    }
}
