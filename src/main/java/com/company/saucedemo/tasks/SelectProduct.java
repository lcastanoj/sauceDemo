package com.company.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;
import com.company.saucedemo.ui.ProductPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProduct implements Task {
    private final String name;

    public SelectProduct(String name) {
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductPage.ITEM_BY_NAME.of(name)));
    }

    public static SelectProduct called(String name) {
        return instrumented(SelectProduct.class, name);
    }
}