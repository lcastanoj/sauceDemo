package com.company.saucedemo.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class QuestionsPage {
    public static final Target MESSAGE = Target.the("confirmation message")
            .located(By.className("complete-header"));
}
