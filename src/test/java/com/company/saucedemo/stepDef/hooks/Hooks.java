package com.company.saucedemo.stepDef.hooks;

import com.company.saucedemo.tasks.LogOut;
import com.company.saucedemo.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.*;

public class Hooks {

    @Before(order = 0)
    public void setUp() {
        setTheStage(new OnlineCast());

        WebDriver customDriver = DriverFactory.getDriver();
        theActorCalled("Lucas")
                .whoCan(BrowseTheWeb.with(customDriver));
    }

    @After
    public void closeDriver() {
        theActorInTheSpotlight().attemptsTo(
                LogOut.app()
        );
    }
}
