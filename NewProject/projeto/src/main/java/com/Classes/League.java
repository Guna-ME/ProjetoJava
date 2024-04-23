package com.Classes;

import java.util.List;

public class League {
    private Long id;
    private List<Series> series;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<Series> getSeries() {
        return series;
    }
    public void setSeries(List<Series> series) {
        this.series = series;
    }

}
