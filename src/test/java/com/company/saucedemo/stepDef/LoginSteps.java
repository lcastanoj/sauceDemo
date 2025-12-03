package com.company.saucedemo.stepDef;

import com.company.saucedemo.questions.LoginErrorMessage;
import com.company.saucedemo.tasks.LoginWith;
import com.company.saucedemo.tasks.OpenTheApp;
import com.company.saucedemo.ui.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginSteps {
    @Given("the user opens the Saucedemo application")
    public void theUserOpensTheSaucedemoApplication() {
        theActorInTheSpotlight().attemptsTo(
                OpenTheApp.on("https://www.saucedemo.com/")
        );
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                LoginWith.credentials(username, password)
        );
    }

    @Then("the user should be redirected to the products page")
    public void theUserShouldBeRedirectedToTheProductsPage() {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(ProductPage.LABEL_PRODUCT).isDisplayed()
        );
    }

    @Then("the login should fail with an error containing {string}")
    public void theLoginShouldFailWithAnErrorContaining(String errorMessage) {
        theActorInTheSpotlight().should(
                seeThat(LoginErrorMessage.contains(errorMessage))
        );
    }
}
