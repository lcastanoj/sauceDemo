package com.retos.sauceDemo.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final Target TXT_USERNAME = Target.the("USERNAME").located(By.id("user-name"));
    public static final Target TXT_PASSWORD = Target.the("PASSWORD").located(By.id("password"));
    public static final Target LBL_ERROR_MESSAGE = Target.the("ERROR MESSAGE LOGIN").locatedBy("//h3[contains(text(), 'Username and password do not match any user in this service')]");
}