package com.retos.sauceDemo.tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.retos.sauceDemo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.retos.sauceDemo.userInterfaces.CheckoutUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
public class CompleteCheckout implements Task {
    private static ArrayList<Map<String, String>> readExcel = new ArrayList<>();

    private int data;

    public CompleteCheckout(int data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            readExcel = Excel.readDataFromExcelSheet("src/test/resources/data/data.xlsx", "Sheet1");
        } catch (IOException e) {
            throw new RuntimeException("Error reading excel file" + e.getMessage());
        }

        actor.attemptsTo(
                Enter.theValue(readExcel.get(data).get("first_name")).into(TXT_NAME),
                Enter.theValue(readExcel.get(data).get("last_name")).into(TXT_LAST_NAME),
                Enter.theValue(readExcel.get(data).get("postal_code")).into(TXT_POSTAL_CODE),
                Click.on(BUTTON_CONTINUE),
                Click.on(BUTTON_FINISH)
        );
    }

    public static Performable info(int data) {
        return instrumented(CompleteCheckout.class, data);
    }
}