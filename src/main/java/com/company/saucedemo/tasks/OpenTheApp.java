package com.company.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OpenTheApp implements Task {
    private final String url;

    public OpenTheApp(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }

    public static OpenTheApp on(String url) {
        return instrumented(OpenTheApp.class, url);
    }
}