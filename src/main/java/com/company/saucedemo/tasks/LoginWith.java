package com.company.saucedemo.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Actor;
import com.company.saucedemo.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginWith implements Task {
    private final String username;
    private final String password;

    public LoginWith(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPage.USERNAME),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BTN)
        );
    }

    public static LoginWith credentials(String user, String pass) {
        return instrumented(LoginWith.class, user, pass);
    }
}