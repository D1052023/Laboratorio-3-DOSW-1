package edu.dosw.lab;

import java.util.Arrays;
import java.util.List;
public class Member {
    private String name;
    private int vote;
    private static final List<Integer> values = Arrays.asList(1, 2, 3, 5, 8, 13);

    public Member(String name) {
        this.name = name;
        this.vote = -1;
    }

    public Member(String name, int vote) {
        this.name = name;
        setVote(vote);
    }
    public String getName() {
        return name;
    }
    public int getVote(){
        return vote;
    }
    public void setVote(int vote) {
        if (!values.contains(vote)) {
            throw new IllegalArgumentException("El voto no es válido. Debe ser un número Fibonacci permitido.");
        }
        this.vote = vote;
    }
    public void restartVote() {
        this.vote = -1;
    }
}