package com.example.apa.Model.Activity;

public class ActivityToPatient {

    private String idActivity, idPatient;

    public ActivityToPatient(String idActivity, String idPatient) {
        this.idActivity = idActivity;
        this.idPatient = idPatient;
    }

    public String getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(String idActivity) {
        this.idActivity = idActivity;
    }

    public String getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(String idPatient) {
        this.idPatient = idPatient;
    }
}
