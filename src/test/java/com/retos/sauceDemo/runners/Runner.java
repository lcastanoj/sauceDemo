package com.retos.sauceDemo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.retos.sauceDemo.stepDefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class Runner {

}