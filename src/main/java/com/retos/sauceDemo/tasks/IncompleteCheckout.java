package com.retos.sauceDemo.tasks;

import com.retos.sauceDemo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.retos.sauceDemo.userInterfaces.CheckoutUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IncompleteCheckout implements Task {
    private static ArrayList<Map<String, String>> readExcel = new ArrayList<>();
    private int arg0;

    public IncompleteCheckout(int arg0) {
        this.arg0 = arg0;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            readExcel = Excel.readDataFromExcelSheet("src/test/resources/data/data.xlsx", "Hoja1");
        } catch (IOException e) {
            throw new RuntimeException("Error reading excel file" + e.getMessage());
        }

        actor.attemptsTo(
                Enter.theValue(readExcel.get(arg0).get("first_name")).into(TXT_NAME),
                Enter.theValue(readExcel.get(arg0).get("last_name")).into(TXT_LAST_NAME),
                Click.on(BUTTON_CONTINUE)
                );
    }

    public static Performable info(int arg0) {
        return instrumented(IncompleteCheckout.class, arg0);
    }
}
