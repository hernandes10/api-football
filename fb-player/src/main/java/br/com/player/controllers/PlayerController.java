package br.com.player.controllers;

import br.com.player.domain.DTO.PlayerDTO;
import br.com.player.domain.entities.Player;
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
 interface PlayerController{

    @GetMapping("/v1/player")
    @Tag(name = "Player-V1")
    @Operation(summary = "get all players with pagination", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Players not found") })
     List<PlayerDTO> getPlayers(@RequestParam(defaultValue = "0") Integer pageNo,
                                @RequestParam(defaultValue = "name") String sortBy);

    @GetMapping("/v1/player/team/{teamId}")
    @Tag(name = "Player-V1")
    @Operation(summary = "get all players of the team", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Players not found") })
    List<PlayerDTO> getPlayersByTeam(@PathVariable Long teamId);

    @PutMapping("/v1/player")
    @Tag(name = "Player-V1")
    @Operation(summary = "Update player's data", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                    schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Player not found") })
     ResponseEntity<String> updatePlayer(@RequestBody PlayerDTO playerDTO);

    @DeleteMapping("/v1/player/{id}")
    @Tag(name = "Player-V1")
    @Operation(summary = "Delete player's data", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                    schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Player not found") })
     ResponseEntity<String> deletePlayer(@PathVariable Long id);

    @GetMapping("/v1/player/{id}")
    @Tag(name = "Player-V1")
    @Operation(summary = "get a player by id", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Players not found") })
     PlayerDTO getPlayer(@PathVariable Long id) throws ResponseStatusException;

    @PostMapping("/v1/player/")
    @Tag(name = "Player-V1")
    @Operation(summary = "create a new player", responses = {
            @ApiResponse(content = @Content(mediaType = MediaType.TEXT_PLAIN_VALUE,
                    schema = @Schema(implementation = Player.class))),
            @ApiResponse(responseCode = "400", description = "Players not found") })
     ResponseEntity<String> createPlayer(@RequestBody PlayerDTO player);
}
