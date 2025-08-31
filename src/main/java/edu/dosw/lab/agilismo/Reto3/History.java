package edu.dosw.lab.agilismo.Reto3;

public class History {
    private final int id;
    private final String actor;
    private final String description;
    private Integer finalScore;

    public History(int id, String actor, String description) {
        this.id = id;
        this.actor = actor != null ? actor.trim() : "";
        this.description = description != null ? description.trim() : "";
    }

    public int getId() {
        return id;
    }

    public String getActor() {
        return actor;
    }

    public String getDescription() {
        return description;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return id + ": " + actor + " - " + description + "/n - Estimación final: " + (finalScore != null ? finalScore : "No asignada");
    }
}
