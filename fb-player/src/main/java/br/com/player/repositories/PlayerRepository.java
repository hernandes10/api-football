package br.com.player.repositories;

import br.com.player.domain.entities.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends CrudRepository<Player,  Long> {

    List<Player> findAll(Pageable paging);

    Optional<List<Player>> findByTeamIdOrderByTeamName(Long teamId);
}
