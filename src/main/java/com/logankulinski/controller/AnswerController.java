package com.logankulinski.controller;

import com.logankulinski.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public final class AnswerController {
    private final AnswerService service;

    @Autowired
    public AnswerController(AnswerService service) {
        Objects.requireNonNull(service);

        this.service = service;
    }

    @QueryMapping
    public String getAnswer(@Argument String prompt) {
        return this.service.getAnswer(prompt);
    }
}
