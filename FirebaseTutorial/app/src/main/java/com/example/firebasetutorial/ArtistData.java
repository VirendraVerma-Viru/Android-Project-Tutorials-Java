package com.example.firebasetutorial;

public class ArtistData {

    String id;
    String name;

    public ArtistData() {
    }

    public ArtistData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
