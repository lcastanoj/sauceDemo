package com.company.saucedemo.questions;

import com.company.saucedemo.ui.LoginPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Actor;

public class LoginErrorMessage implements Question<Boolean> {

    private final String expected;

    public LoginErrorMessage(String expected) {
        this.expected = expected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String text = LoginPage.ERROR_MSG.resolveFor(actor).getText().trim();
        return text.contains(expected);
    }

    public static LoginErrorMessage contains(String expected) {
        return new LoginErrorMessage(expected);
    }
}
