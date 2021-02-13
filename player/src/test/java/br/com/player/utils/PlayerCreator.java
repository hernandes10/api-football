package br.com.player.utils;

import br.com.player.domain.DTO.PlayerDTO;
import br.com.player.domain.entities.Player;
import br.com.player.domain.entities.Position;
import br.com.player.domain.entities.Team;

import java.util.ArrayList;
import java.util.List;

public class PlayerCreator {

    public static Player createPlayerToBeSaved(String name,int number){
        return Player.builder()
                .name(name)
                .number(number)
                .position(new Position(1L))
                .team(new Team(1L))
                .build();
    }

    public static List<PlayerDTO> getListPlayers() {
        List<PlayerDTO> list = new ArrayList<PlayerDTO>();
        list.add(createPlayerDTO());
        return list;
    }

    public static PlayerDTO createPlayerDTO(){
        return PlayerDTO.builder()
                .name("Fred")
                .id(1L)
                .positionId(2L)
                .positionType("GK")
                .teamId(1L)
                .teamName("Cruzeiro").build();

    }
}
