package com.herokuapp.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class SelectAlertPromptTask implements Task {
    private String message;

    public SelectAlertPromptTask(String message){
        this.message=message;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

    }
}
