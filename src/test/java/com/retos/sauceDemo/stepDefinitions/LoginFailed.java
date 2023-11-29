package com.retos.sauceDemo.stepDefinitions;

import com.retos.sauceDemo.utils.Excel;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.retos.sauceDemo.userInterfaces.LoginUI.LBL_ERROR_MESSAGE;

public class LoginFailed {
    @Then("I will validate the error message {int}")
    public void iWillValidateTheErrorMessage(Integer arg0) {
        ArrayList<Map<String, String>> readExcel = new ArrayList<>();
        try {
            readExcel = Excel.readDataFromExcelSheet("src/test/resources/data/data.xlsx", "Hoja1");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        OnStage.theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(WebElementQuestion.the(LBL_ERROR_MESSAGE),
                        WebElementStateMatchers.containsText(readExcel.get(arg0).get("validation"))));
    }
}
