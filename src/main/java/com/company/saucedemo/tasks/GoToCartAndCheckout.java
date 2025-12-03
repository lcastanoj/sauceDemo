package com.company.saucedemo.tasks;

import com.company.saucedemo.ui.ProductPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GoToCartAndCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductPage.CHECKOUT_BUTTON));
    }

    public static GoToCartAndCheckout toCheckout() {
        return instrumented(GoToCartAndCheckout.class);
    }
}