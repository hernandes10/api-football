package br.com.player.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlayerDTO {
    private Long id;
    private String name;
    private int number;
    private Long teamId;
    private String teamName;
    private String positionName;
    private Long positionId;
    private String positionType;
}
