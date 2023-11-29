package com.retos.sauceDemo.userInterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutUI {
    public static final Target TXT_NAME = Target.the("NAME").located(By.id("first-name"));
    public static final Target TXT_LAST_NAME = Target.the("LAST NAME").located(By.id("last-name"));
    public static final Target TXT_POSTAL_CODE = Target.the("POSTAL CODE").located(By.id("postal-code"));
    public static final Target BUTTON_CONTINUE = Target.the("BUTTON CONTINUE").located(By.id("continue"));
    public static final Target BUTTON_FINISH = Target.the("FINISH").located(By.id("finish"));
    public static final Target LBL_CONFIRMATION = Target.the("CONFIRMATION").locatedBy("//h2[contains(text(), 'Thank you for your order!')]");
    public static final Target LBL_ERROR_CHECKOUT = Target.the("ERROR CHECKOUT").locatedBy("//h3[contains(text(), 'Error')]");
}