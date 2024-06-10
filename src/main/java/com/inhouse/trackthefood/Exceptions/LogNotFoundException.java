package com.inhouse.trackthefood.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No such log exists.")
public class LogNotFoundException extends RuntimeException {

}
