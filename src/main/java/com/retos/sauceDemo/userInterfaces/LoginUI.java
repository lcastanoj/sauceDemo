package com.retos.sauceDemo.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI {
    public static final Target TXT_USERNAME = Target.the("USERNAME").located(By.id("user-name"));
    public static final Target TXT_PASSWORD = Target.the("PASSWORD").located(By.id("password"));
}