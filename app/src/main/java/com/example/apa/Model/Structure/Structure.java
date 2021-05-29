package com.example.apa.Model.Structure;

import com.example.apa.Model.Activity.ActivitySport;

import java.util.ArrayList;

public class Structure {
    private ArrayList<ActivitySport> activitySports;
    private ArrayList<String> pathology;
    private String name;
    private String discipline;

    public Structure(String name, String discipline) {
        this.activitySports = new ArrayList<>();
        this.pathology = new ArrayList<>();
        this.name = name;
        this.discipline = discipline;
    }

    public ArrayList<ActivitySport> getActivitySports() {
        return activitySports;
    }

    public void setActivitySports(ArrayList<ActivitySport> activitySports) {
        this.activitySports = activitySports;
    }

    public ArrayList<String> getPathology() {
        return pathology;
    }

    public void setPathology(ArrayList<String> pathology) {
        this.pathology = pathology;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
