package com.company.saucedemo.tasks;

import com.company.saucedemo.ui.ProductPage;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillCheckoutInformation implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public FillCheckoutInformation(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(ProductPage.FIRST),
                Enter.theValue(lastName).into(ProductPage.LAST),
                Enter.theValue(postalCode).into(ProductPage.POSTAL),
                Click.on(ProductPage.CONTINUE)
        );
    }

    public static FillCheckoutInformation with(String firstName, String lastName, String postalCode) {
        return instrumented(FillCheckoutInformation.class, firstName, lastName, postalCode);
    }
}