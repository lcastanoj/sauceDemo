package com.retos.sauceDemo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.retos.sauceDemo.userInterfaces.ShopUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Logout implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HAMBURGER_BUTTON),
                Click.on(LOG_OUT_BUTTON)
        );
    }

     public static Performable theweb() {
        return instrumented(Logout.class);
    }
}
