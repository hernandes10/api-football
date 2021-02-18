package br.com.team.controllers;

import br.com.team.domain.DTO.TeamDTO;
import br.com.team.domain.entities.Team;
import br.com.team.domain.entities.Team;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin(origins = "*")
public interface TeamController {

    @GetMapping("/v1/team")
    @Tag(name = "Team-V1")
    @Operation(summary = "get all Teams with pagination", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Team.class))),
            @ApiResponse(responseCode = "400", description = "Teams not found") })
    List<TeamDTO> getTeams(@RequestParam(defaultValue = "0") Integer pageNo,
                               @RequestParam(defaultValue = "name") String sortBy);

    @GetMapping("/v1/team/team/{teamId}")
    @Tag(name = "Team-V1")
    @Operation(summary = "get all Teams of the team", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Team.class))),
            @ApiResponse(responseCode = "400", description = "Teams not found") })
    List<TeamDTO> getTeamsByLeague(@PathVariable Long teamId);

    @PutMapping("/v1/team")
    @Tag(name = "Team-V1")
    @Operation(summary = "Update Team's data", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                    schema = @Schema(implementation = Team.class))),
            @ApiResponse(responseCode = "400", description = "Team not found") })
    ResponseEntity<String> updateTeam(@RequestBody TeamDTO TeamDTO);

    @DeleteMapping("/v1/team/{id}")
    @Tag(name = "Team-V1")
    @Operation(summary = "Delete Team's data", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                    schema = @Schema(implementation = Team.class))),
            @ApiResponse(responseCode = "400", description = "Team not found") })
    ResponseEntity<String> deleteTeam(@PathVariable Long id);

    @GetMapping("/v1/team/{id}")
    @Tag(name = "Team-V1")
    @Operation(summary = "get a Team by id", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Team.class))),
            @ApiResponse(responseCode = "400", description = "Teams not found") })
    TeamDTO getTeam(@PathVariable Long id) throws ResponseStatusException;

    @PostMapping("/v1/team/")
    @Tag(name = "Team-V1")
    @Operation(summary = "create a new Team", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                    schema = @Schema(implementation = Team.class))),
            @ApiResponse(responseCode = "400", description = "Teams not found") })
    ResponseEntity<String> createTeam(@RequestBody TeamDTO Team);

}
