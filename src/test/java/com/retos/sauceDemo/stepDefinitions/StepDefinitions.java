package com.retos.sauceDemo.stepDefinitions;

import com.retos.sauceDemo.tasks.*;
import com.retos.sauceDemo.utils.Excel;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.retos.sauceDemo.userInterfaces.CheckoutUI.LBL_CONFIRMATION;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class StepDefinitions {

    @Before
    public void setStage() {
        setTheStage(new OnlineCast());
    }

    @Given("I open the URL")
    public void iOpenTheURL() {
        theActorCalled("Test").wasAbleTo(Open.url("https://www.saucedemo.com/"));
    }

    @When("you enter your login details {int}")
    public void youEnterYourLoginDetails(Integer data) {
        theActorInTheSpotlight().attemptsTo(Login.successful(data));
    }

    @When("make the selection of random items to buy")
    public void makeTheSelectionOfRandomItemsToBuy() {
        theActorInTheSpotlight().attemptsTo(SelectItems.toBuy());
    }

    @When("continue with the checkout {int}")
    public void continueWithTheCheckout(Integer data) {
        theActorInTheSpotlight().attemptsTo(CompleteCheckout.info(data));
    }

    @Then("I will validate that the purchase is successful {int}")
    public void iWillValidateThatThePurchaseIsSuccessful(Integer data) {
        ArrayList<Map<String, String>> readExcel = new ArrayList<>();
        try {
            readExcel = Excel.readDataFromExcelSheet("src/test/resources/data/data.xlsx", "Sheet1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OnStage.theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(WebElementQuestion.the(LBL_CONFIRMATION),
                        WebElementStateMatchers.containsText(readExcel.get(data).get("validation"))));
    }
}