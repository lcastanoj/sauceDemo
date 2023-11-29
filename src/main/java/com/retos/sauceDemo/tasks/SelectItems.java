package com.retos.sauceDemo.tasks;

import com.retos.sauceDemo.interactions.RandomClick;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.retos.sauceDemo.userInterfaces.ShopUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectItems implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                RandomClick.random(),
                Click.on(CART_BUTTON),
                Click.on(CHECKOUT_BUTTON)
        );
    }

    public static SelectItems toBuy() {
        return instrumented(SelectItems.class);
    }
}