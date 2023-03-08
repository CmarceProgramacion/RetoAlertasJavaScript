package com.herokuapp.stepdefinitions;

import com.herokuapp.exceptions.ComparisonException;
import com.herokuapp.questions.ValidatePhraseAlerts;
import com.herokuapp.tasks.SelectAlertAcceptTask;
import com.herokuapp.tasks.SelectAlertConfirmTask;
import com.herokuapp.tasks.SelectAlertPromptTask;
import com.herokuapp.userinterfaces.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

import static com.herokuapp.userinterfaces.JavaScriptAlertsPage.LABEL_MESSAGE;
import static com.herokuapp.utils.enums.MessageExceptions.MESSAGE_NOT_EQUAL;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.fluentlenium.core.filter.MatcherConstructor.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SelectAlertStepDefinitions {
    @Given("that I access the herokuapp platform")
    public void thatIAccessTheHerokuappPlatform() {
        theActorInTheSpotlight().wasAbleTo(
                Open.browserOn().the(HomePage.class)
        );
    }

    @When("I select JS alert and interact with the alert")
    public void iSelectJSAlertAndInteractWithTheAlert() {
        theActorInTheSpotlight().attemptsTo(
                SelectAlertAcceptTask.acceptAlert()
        );
    }

    @When("I select JS Confirm and interact with the alert")
    public void iSelectJSConfirmAndInteractWithTheAlert() {
        theActorInTheSpotlight().attemptsTo(
                SelectAlertConfirmTask.confirmAlert()
        );
    }

    @When("I select JS Prompt interact with the alert and enter the phrase {string}")
    public void iSelectJSPromptInteractWithTheAlertAndEnterThePhrase(String phrase) {
        theActorInTheSpotlight().attemptsTo(
                SelectAlertPromptTask.writeInAlert(phrase)
        );
    }

    /**
     * El método permite verificar que el contenido del label contenga, el texto especifico(phrase).
     * Se implementa la Creación de excepción si la validación falla implementando la clase ComparisonException
     * Se agrega un mensaje de error que indica que la comparación falló y que texto se esperaba
     */

    @Then("verify that Result appears with the phrase {string}")
    public void verifyThatResultAppearsWithThePhrase(String phrase) {
        theActorInTheSpotlight().should(
               GivenWhenThen.seeThat(the(LABEL_MESSAGE), WebElementStateMatchers.containsText(phrase))
                        .orComplainWith(ComparisonException.class, MESSAGE_NOT_EQUAL.getMessageException()+phrase)
        );
    }
}
