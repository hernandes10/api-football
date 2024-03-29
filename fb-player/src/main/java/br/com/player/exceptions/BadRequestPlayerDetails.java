package br.com.player.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BadRequestPlayerDetails {

    private String title;
    private int status;
    private String details;
    private String developerMessage;
    private LocalDateTime time;

}
