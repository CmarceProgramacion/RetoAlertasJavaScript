package com.herokuapp.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/select_alerts.feature",
        glue="com.herokuapp.stepdefinitions",
        tags="@CaseOne",
        plugin={"pretty"},
        snippets=CucumberOptions.SnippetType.CAMELCASE
)

public class SelectAlertsRunners {
}
