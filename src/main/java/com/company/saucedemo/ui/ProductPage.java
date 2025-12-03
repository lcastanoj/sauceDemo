package com.company.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductPage {
    public static final Target CART_BTN = Target.the("cart button")
            .locatedBy("//div[@id='shopping_cart_container']");

    public static final Target FINISH = Target.the("finish")
            .located(By.id("finish"));

    public static final Target FIRST = Target.the("first name")
            .located(By.id("first-name"));
    public static final Target LAST = Target.the("last name")
            .located(By.id("last-name"));
    public static final Target POSTAL = Target.the("postal code")
            .located(By.id("postal-code"));
    public static final Target CONTINUE = Target.the("continue")
            .located(By.id("continue"));

    public static final Target CHECKOUT_BUTTON = Target.the("checkout button")
            .located(By.id("checkout"));

    public static final Target ITEM_BY_NAME = Target.the("item by name")
            .locatedBy("//div[contains(text(), '{0}')]");

    public static final Target LABEL_PRODUCT = Target.the("label product")
            .locatedBy("//span[contains(text(), 'Products')]");

    public static final Target MENU_BTN = Target.the("menu button")
            .located(By.id("react-burger-menu-btn"));
    public static final Target LOGOUT_BTN = Target.the("logout button")
            .located(By.id("logout_sidebar_link"));
}
