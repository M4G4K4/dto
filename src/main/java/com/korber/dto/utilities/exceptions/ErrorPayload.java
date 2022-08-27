package com.korber.dto.utilities.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorPayload {
    private String message;
    private String description;
    private int status;

    public static ErrorPayload error(final String message){
        return error(message, null);
    }

    public static ErrorPayload error(final String message, final String description){
        return error(message, description);
    }

}
