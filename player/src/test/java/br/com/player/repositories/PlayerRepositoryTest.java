package br.com.player.repositories;

import br.com.player.domain.entities.Player;
import br.com.player.utils.PlayerCreator;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@DataJpaTest
@DisplayName("Tests for Player Repository")
@Log4j2
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    @DisplayName("Find all player in page one, sort by name when successful.")
    void itShouldfindAll() {
        Player player = PlayerCreator.createPlayerToBeSaved("Fabio",1);
        Player playerSaved = this.playerRepository.save(player);
        Pageable paging = PageRequest.of(0, 1, Sort.by("name"));
        List<Player> playerList = this.playerRepository.findAll(paging);

        Assertions.assertThat(playerList)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1)
                .contains(playerSaved);

    }
}