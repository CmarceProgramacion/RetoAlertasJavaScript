package com.herokuapp.utils.enums;

public enum MessageExceptions {
    MESSAGE_NOT_EQUAL("The message is different than expected: ");

    private final String messageException;

    MessageExceptions(String messageException) {
        this.messageException = messageException;
    }

    public String getMessageException() {
        return messageException;
    }
}
