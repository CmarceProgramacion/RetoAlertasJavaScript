package com.herokuapp.utils.enums;

public enum OptionAlertEnum {
    OPTIONS_EXAMPLES_ALERTS("JavaScript Alerts");
    private final String option;

    OptionAlertEnum(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
