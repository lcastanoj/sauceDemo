package com.company.saucedemo.tasks;

import com.company.saucedemo.ui.ProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogOut implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if (ProductPage.MENU_BTN.isVisibleFor(actor)) {
            actor.attemptsTo(
                    Click.on(ProductPage.MENU_BTN),
                    Click.on(ProductPage.LOGOUT_BTN)
            );
        }
    }

    public static LogOut app() {
        return instrumented(LogOut.class);
    }
}
