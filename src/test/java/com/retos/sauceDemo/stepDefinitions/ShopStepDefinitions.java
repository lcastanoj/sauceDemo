package com.retos.sauceDemo.stepDefinitions;

import com.retos.sauceDemo.tasks.*;
import com.retos.sauceDemo.utils.Excel;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.retos.sauceDemo.userInterfaces.CheckoutUI.LBL_CONFIRMATION;
import static com.retos.sauceDemo.userInterfaces.LoginUI.LBL_ERROR_MESSAGE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ShopStepDefinitions {
    @When("I make the selection of random items to buy")
    public void iMakeTheSelectionOfRandomItemsToBuy() {
        theActorInTheSpotlight().attemptsTo(SelectItems.toBuy());
    }

    @When("I continue with the checkout {int}")
    public void iContinueWithTheCheckout(Integer arg0) {
        theActorInTheSpotlight().attemptsTo(CompleteCheckout.info(arg0));
    }

    @Then("I will validate that the purchase is successful {int}")
    public void iWillValidateThatThePurchaseIsSuccessful(Integer arg0) {
        ArrayList<Map<String, String>> readExcel = new ArrayList<>();
        try {
            readExcel = Excel.readDataFromExcelSheet("src/test/resources/data/data.xlsx", "Hoja1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OnStage.theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(WebElementQuestion.the(LBL_CONFIRMATION),
                        WebElementStateMatchers.containsText(readExcel.get(arg0).get("validation"))));
    }
}
