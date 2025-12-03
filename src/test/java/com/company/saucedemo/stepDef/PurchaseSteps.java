package com.company.saucedemo.stepDef;

import com.company.saucedemo.questions.ConfirmationMessage;
import com.company.saucedemo.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class PurchaseSteps {

    @And("the user selects the product {string}")
    public void theUserSelectsTheProduct(String product) {
        theActorInTheSpotlight().attemptsTo(
                SelectProduct.called(product)
        );
    }

    @And("the user adds the product to the cart")
    public void theUserAddsTheProductToTheCart() {
        theActorInTheSpotlight().attemptsTo(
                AddToCart.now()
        );
    }

    @And("the user proceeds to checkout with first name {string} last name {string} postal code {string}")
    public void theUserProceedsToCheckoutWithFirstNameLastNamePostalCode(String name, String lastName, String postalCode) {
        theActorInTheSpotlight().attemptsTo(
                GoToCartAndCheckout.toCheckout(),
                FillCheckoutInformation.with(name, lastName, postalCode),
                FinishPurchase.now());
    }

    @Then("the user should see the confirmation message {string}")
    public void theUserShouldSeeTheConfirmationMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(
                        ConfirmationMessage.equalsTo(message),
                        equalTo(true)
                )
        );
    }
}
