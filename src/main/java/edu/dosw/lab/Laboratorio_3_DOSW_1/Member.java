package edu.dosw.lab.Laboratorio_3_DOSW_1;

public class Integrante {
    private String name;
    private int votation;
    public Integrante(String name, int votation) {
        this.name = name;
        this.votation = votation;
    }
    public String getName() {
        return name;
    }
    public void getVotes(){
        System.out.println(votation);
    }
}
