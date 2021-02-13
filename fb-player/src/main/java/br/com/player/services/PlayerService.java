package br.com.player.services;

import br.com.player.domain.DTO.PlayerDTO;
import br.com.player.domain.entities.Player;
import br.com.player.repositories.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PlayerDTO> getPlayers(Integer pageNo,String sortBy) {
        Pageable paging = PageRequest.of(pageNo, 10, Sort.by(sortBy));
        return new ModelMapper().map(playerRepository.findAll(paging),
                new TypeToken<List<PlayerDTO>>() {}.getType());
    }

    public void mergePlayer(PlayerDTO playerDTO) {
        playerRepository.save(modelMapper.map(playerDTO,Player.class));
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }

    public Optional<PlayerDTO> getPlayerById(Long id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent())
            return Optional.of(modelMapper.map(player.get(),PlayerDTO.class));

        return Optional.ofNullable(null);
    }

    public Optional<List<PlayerDTO>> getPlayerByTeam(Long teamId) {

        Optional<List<Player>> playerList =  playerRepository.findByTeamIdOrderByTeamName(teamId);
        List<PlayerDTO> listDTO = new ArrayList<PlayerDTO>();
        if(playerList.isPresent()){


            playerList.get().stream().forEach( p ->
                listDTO.add(modelMapper.map(p,PlayerDTO.class))
            );
        }
            return Optional.of( listDTO );


    }
}
