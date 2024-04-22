package com.example.Servico;

import java.util.ArrayList;
import java.util.List;
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

}
