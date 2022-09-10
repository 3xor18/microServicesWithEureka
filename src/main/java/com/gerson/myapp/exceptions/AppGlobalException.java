package com.gerson.myapp.exceptions;
import com.gerson.myapp.exceptions.dtos.ErrorDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AppGlobalException extends Exception {

    private static final long serialVersionUID = 1L;

    private final int responseCode;

    private final List<ErrorDto> errorsList = new ArrayList<>();

    public AppGlobalException(int responseCode, String message) {
        super(message);
        this.responseCode = responseCode;
    }
}