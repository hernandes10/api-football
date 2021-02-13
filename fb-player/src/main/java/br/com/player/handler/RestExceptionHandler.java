package br.com.player.handler;

import br.com.player.exceptions.BadRequestPlayer;
import br.com.player.exceptions.BadRequestPlayerDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

//@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestPlayer.class)
    public ResponseEntity<BadRequestPlayerDetails> handlerBadRequestPlayer(BadRequestPlayer brp){
        return new ResponseEntity<>(
                BadRequestPlayerDetails.builder()
                    .time(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Bad Request Exception, check the documentation.")
                .details(brp.getMessage())
                .developerMessage(brp.getClass().getName())
                .build(),HttpStatus.BAD_REQUEST
        );
    }

}
