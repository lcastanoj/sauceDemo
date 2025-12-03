package com.company.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;
import com.company.saucedemo.ui.ProductPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCart implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductPage.CART_BTN));
    }

    public static AddToCart now() {
        return instrumented(AddToCart.class);
    }
}