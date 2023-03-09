package com.herokuapp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.herokuapp.userinterfaces.MultipleWindowsPage.LABEL_MESSAGE_NEW_WINDOW;

public class VerifyPhraseWindows implements Question<Boolean> {
    private String phrase;

    public VerifyPhraseWindows(String phrase) {
        this.phrase = phrase;
    }

    public static VerifyPhraseWindows verify(String phrase) {
        return new VerifyPhraseWindows(phrase);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return LABEL_MESSAGE_NEW_WINDOW.resolveFor(actor).getTextContent().contains(phrase);
    }
}
