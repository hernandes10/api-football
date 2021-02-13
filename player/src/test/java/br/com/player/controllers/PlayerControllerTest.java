package br.com.player.controllers;

import br.com.player.domain.DTO.PlayerDTO;
import br.com.player.services.PlayerService;
import br.com.player.utils.PlayerCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
class PlayerControllerTest {

    @InjectMocks
    private PlayerControllerImp playerControllerImp;

    @Mock
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        BDDMockito.when(playerService.getPlayers(ArgumentMatchers.anyInt(),ArgumentMatchers.anyString()))
                .thenReturn(PlayerCreator.getListPlayers());
    }

    @Test
    @DisplayName("It should get all players")
    void itShouldGetPlayers() {
        List<PlayerDTO> allPlayer = playerService.getPlayers(0,"name");

        Assertions.assertThat(allPlayer).isNotNull()
                .isNotEmpty()
                .hasSize(1);
    }

    //@Test
    @DisplayName("It should update the player data")
    void itShouldUpdatePlayer() {
    }

    //@Test
    @DisplayName("It should delete player from data base")
    void itShouldDeletePlayer() {
    }

   // @Test
    @DisplayName("It should get one players")
    void itShouldGetPlayer() {
    }

    //@Test
    @DisplayName("It should create a new player")
    void itShouldCreatePlayer() {
    }
}