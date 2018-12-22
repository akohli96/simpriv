package com.simpriv.api.port.primary.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SnippetCreateCommand extends SnippetDTO {

    private String receiver;

    @JsonCreator
    public SnippetCreateCommand(@JsonProperty("message") String message,@JsonProperty("receiver") String receiver)
    {
        super(message);
        this.receiver=receiver;
    }

    public String getReceiver() {
        return this.receiver;
    }
}
