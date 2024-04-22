package com.example.Controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Classes.Game;
import com.Classes.VideoGame;
import com.example.Servico.Servico;

@RestController
@RequestMapping("/api/games")
public class Controlando {

    @Autowired
    private Servico servico;

    @GetMapping
    public List<Game> getAllGames() {
        return servico.getAllGames();
    }

    @PostMapping
    public Game addGame(@RequestBody Game game) {
        return servico.addGame(game);
    }

    @GetMapping("/videogames")
    public List<VideoGame> getAllVideoGames() {
        return servico.getAllVideoGames().collectList().block();
    }

    @GetMapping("/favorites")
    public List<Game> getFavoriteGames() {
        return servico.getFavoriteGames();
    }

}

