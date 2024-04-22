package com.Classes;

public class Game {
    private String id;
    private String teamA;
    private String teamB;
    private int scoreTeamA;
    private int scoreTeamB;
    private boolean favorite;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTeamA() {
        return teamA;
    }
    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }
    public String getTeamB() {
        return teamB;
    }
    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }
    public int getScoreTeamA() {
        return scoreTeamA;
    }
    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }
    public int getScoreTeamB() {
        return scoreTeamB;
    }
    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }
    public boolean isFavorite() {
        return favorite;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
  
}
