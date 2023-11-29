package com.retos.sauceDemo.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.List;
import java.util.Random;

import static com.retos.sauceDemo.userInterfaces.ShopUI.ADD_TO_CART_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class RandomClick implements Interaction {

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random random = new Random();

        int maxNumberOfClicks = random.nextInt(6) + 1;
        System.out.println(maxNumberOfClicks);

        for (int i = 0; i < maxNumberOfClicks; i++) {
            List<WebElementFacade> nameList = ADD_TO_CART_BUTTON.resolveAllFor(actor);
            if (!nameList.isEmpty()) {
                int randomItem = random.nextInt(nameList.size());
                nameList.get(randomItem).click();
            } else {
                System.out.println("The list is empty.");
                break;
            }
        }
    }

    public static Performable random() {
        return instrumented(RandomClick.class);
    }
}