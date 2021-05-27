package com.example.apa.Model.Activity;

public class ActivitySport {
    private String Titre, Duration, Description;

    public ActivitySport(String titre, String duration, String description) {
        Titre = titre;
        Duration = duration;
        Description = description;
    }

    public ActivitySport() {
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
