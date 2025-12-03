package com.company.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME = Target.the("username")
            .locatedBy("//input[@id='user-name']");
    public static final Target PASSWORD = Target.the("password")
            .locatedBy("//input[@id='password']");
    public static final Target LOGIN_BTN = Target.the("button login")
            .locatedBy("//input[@id='login-button']");

    public static final Target ERROR_MSG = Target.the("error msg")
            .located(By.cssSelector("h3[data-test='error']"));
}
