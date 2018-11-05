
package org.folio.rest.jaxrs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Message
 * <p>
 * Message model
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message"
})
public class Message {

    /**
     * message string
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("message string")
    private String message;

    /**
     * message string
     * 
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * message string
     * 
     */
    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Message withMessage(String message) {
        this.message = message;
        return this;
    }

}
