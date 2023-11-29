package com.retos.sauceDemo.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShopUI {
    public static final Target ADD_TO_CART_BUTTON = Target.the("ADD TO CART BUTTON").locatedBy("//button[contains(text(), 'Add to cart')] ");
    public static final Target CART_BUTTON = Target.the("CART BUTTON").located(By.id("shopping_cart_container"));
    public static final Target CHECKOUT_BUTTON = Target.the("CHECKOUT BUTTON").located(By.id("checkout"));

}
