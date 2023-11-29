package com.retos.sauceDemo.stepDefinitions;

import com.retos.sauceDemo.tasks.IncompleteCheckout;
import com.retos.sauceDemo.utils.Excel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.retos.sauceDemo.userInterfaces.CheckoutUI.LBL_ERROR_CHECKOUT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ShopFailedStepDefinitions {

    @Then("I will validate that the error message on checkout web {int}")
    public void iWillValidateThatThePurchaseIsSuccessful(Integer arg0) throws InterruptedException {
        ArrayList<Map<String, String>> readExcel = new ArrayList<>();
        try {
            readExcel = Excel.readDataFromExcelSheet("src/test/resources/data/data.xlsx", "Hoja1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Thread.sleep(2000);
       theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(WebElementQuestion.the(LBL_ERROR_CHECKOUT),
                        WebElementStateMatchers.containsText(readExcel.get(arg0).get("validation"))));
    }

    @And("I continue with the payment without entering all the data {int}")
    public void iContinueWithThePaymentWithoutEnteringAllTheDataItems(Integer arg0) {
        theActorInTheSpotlight().attemptsTo(IncompleteCheckout.info(arg0));
    }
}
