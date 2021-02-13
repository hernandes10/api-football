package br.com.player.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestPlayer extends RuntimeException{

    public BadRequestPlayer(String message) {
        super(message);
    }
}
