package com.retos.sauceDemo.tasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.retos.sauceDemo.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static com.retos.sauceDemo.userInterfaces.LoginUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    private static ArrayList<Map<String, String>> readExcel = new ArrayList<>();
    private int arg0;

    public Login(int arg0) {
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
                Enter.theValue(readExcel.get(arg0).get("username")).into(TXT_USERNAME),
                Enter.theValue(readExcel.get(arg0).get("password")).into(TXT_PASSWORD).thenHit(Keys.ENTER)
        );
    }

    public static Performable successful(int arg0) {
        return instrumented(Login.class, arg0);
    }
}