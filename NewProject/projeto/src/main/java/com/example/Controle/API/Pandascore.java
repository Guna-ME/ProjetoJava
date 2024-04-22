package com.example.Controle.API;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.Classes.VideoGame;

import reactor.core.publisher.Flux;

@Component
public class Pandascore {
    
    private final WebClient webClient;

    private static final String BASE_URL = "https://api.pandascore.co/videogames";
    private static final String TOKEN = "08AxRC-6b0irhYCdfKom93T6xKa1v4K6dl-kD0gKxGCV1tkqnOU";

    public Pandascore() {
        this.webClient = WebClient.builder()
                                  .baseUrl(BASE_URL)
                                  .defaultHeader("Authorization", "Bearer " + TOKEN)
                                  .build();
    }

    public Flux<VideoGame> getAllVideoGames() {
        return webClient.get()
                        .retrieve()
                        .bodyToFlux(VideoGame.class);
    }
}

