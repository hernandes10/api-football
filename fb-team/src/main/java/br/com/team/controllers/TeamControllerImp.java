package br.com.team.controllers;

import br.com.team.domain.DTO.TeamDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class TeamControllerImp implements TeamController{
    @Override
    public List<TeamDTO> getTeams(Integer pageNo, String sortBy) {
        return null;
    }

    @Override
    public List<TeamDTO> getTeamsByLeague(Long teamId) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateTeam(TeamDTO TeamDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteTeam(Long id) {
        return null;
    }

    @Override
    public TeamDTO getTeam(Long id) throws ResponseStatusException {
        return null;
    }

    @Override
    public ResponseEntity<String> createTeam(TeamDTO Team) {
        return null;
    }
}
