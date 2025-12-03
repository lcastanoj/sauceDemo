package com.company.saucedemo.questions;

import com.company.saucedemo.ui.QuestionsPage;
import net.serenitybdd.screenplay.Question;

public class ConfirmationMessage implements Question<Boolean> {

    private final String expected;

    public ConfirmationMessage(String expected) {
        this.expected = expected;
    }

    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        String text = QuestionsPage.MESSAGE.resolveFor(actor).getText().trim();
        return text.contains(expected);
    }

    public static ConfirmationMessage equalsTo(String expected) {
        return new ConfirmationMessage(expected);
    }
}