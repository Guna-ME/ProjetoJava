package com.example.Servico;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Classes.Game;
import com.Classes.VideoGame;
import com.example.Controle.API.Pandascore;

import reactor.core.publisher.Flux;

@Service
public class Servico {

    @Autowired
    private Pandascore pandascore;

    private List<Game> games = new ArrayList<>();

    public List<Game> getAllGames() {
        return games;
    }

    public Game addGame(Game game) {
        games.add(game);
        return game;
    }

    public Flux<VideoGame> getAllVideoGames() {
        return pandascore.getAllVideoGames();
    }

    public List<Game> getFavoriteGames() {
        return games.stream()
                    .filter(Game::isFavorite)
                    .collect(Collectors.toList());
    }

    public Optional<Game> markGameAsFavorite(String gameId, boolean favorite) {
        Optional<Game> gameOptional = games.stream()
                                           .filter(game -> gameId.equals(game.getId()))
                                           .findFirst();

        gameOptional.ifPresent(game -> game.setFavorite(favorite));

        return gameOptional;
    }

    public Flux<Game> getLiveGames() {
        LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
    
        return pandascore.getAllVideoGames()
            .flatMap(videoGame -> Flux.fromIterable(videoGame.getLeagues())
                .flatMap(league -> Flux.fromIterable(league.getSeries())
                    .filter(series -> {
                        LocalDateTime beginAt = LocalDateTime.parse(series.getBeginAt());
                        LocalDateTime endAt = LocalDateTime.parse(series.getEndAt());
                        return now.isAfter(beginAt) && now.isBefore(endAt);
                    })
                    .map(series -> {
                        Game game = new Game();
                        game.setId(String.valueOf(series.getId()));
                        game.setTeamA("");  
                        game.setTeamB(""); 
                        game.setScoreTeamA(0);  
                        game.setScoreTeamB(0);  
                        game.setFavorite(false);  
                        return game;
                    })
                )
        );
    }

}
