package com.Classes;

import java.util.List;


public class VideoGame {
    private Long id;

    List<League> leagues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }


}
