package br.com.player.controllers;

import br.com.player.domain.DTO.PlayerDTO;
import br.com.player.domain.entities.Player;
import br.com.player.exceptions.BadRequestPlayer;
import br.com.player.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PlayerControllerImp implements PlayerController{

    @Autowired
    private PlayerService playerService;

    @Override
    public List<PlayerDTO> getPlayers(Integer pageNo,String sortBy) {
        return playerService.getPlayers(pageNo, sortBy);
    }

    @Override
    public List<PlayerDTO> getPlayersByTeam(Long teamId) {
        return playerService.getPlayerByTeam(teamId).orElseThrow(
                () -> new BadRequestPlayer("Team not found by id "+teamId)
        );
    }

    @Override
    public ResponseEntity<String> updatePlayer(PlayerDTO playerDTO) {
        playerService.mergePlayer(playerDTO);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deletePlayer(Long id) {
        playerService.delete(id);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @Override
    public PlayerDTO getPlayer(Long id) throws ResponseStatusException {
        return playerService.getPlayerById(id).orElseThrow(
                () ->   new BadRequestPlayer("Player not found by id "+id)
        );
    }

    @Override
    public ResponseEntity<String> createPlayer(PlayerDTO playerDTO) {
        playerService.mergePlayer(playerDTO);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
