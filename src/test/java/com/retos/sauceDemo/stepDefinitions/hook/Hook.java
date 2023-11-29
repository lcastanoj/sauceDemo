package com.retos.sauceDemo.stepDefinitions.hook;

import com.retos.sauceDemo.tasks.Login;
import com.retos.sauceDemo.tasks.Logout;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hook {
    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Given("I open the URL")
    public void iOpenTheURL() {
        theActorCalled("Test").wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @And("I enter login details {int}")
    public void iEnterLoginDetailsAnd(Integer arg0) {
        theActorInTheSpotlight().attemptsTo(Login.successful(arg0));
    }

    @And("I log out")
    public void iLogOut() {
        theActorInTheSpotlight().attemptsTo(Logout.theweb());
    }
}
