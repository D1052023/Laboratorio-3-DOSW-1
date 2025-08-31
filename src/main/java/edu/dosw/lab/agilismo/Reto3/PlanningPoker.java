package edu.dosw.lab.agilismo.Reto3;


import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class PlanningPoker {
    private final List<History> stories;
    private final List<Member> members;
    private final VotingService votingService;

    public PlanningPoker(List<History> stories, List<Member> members, VotingService votingService){
        this.stories = stories;
        this.members = members;
        this.votingService = votingService;
    }

    public void login(Scanner scanner){
        System.out.println("--- Planning poker ---");
        for(History history : stories){
            System.out.println("Estimando: " + history.getId() + " - " + history.getDescription());
            boolean consensusAccomplish = false;
            
            while(!consensusAccomplish) {
                Map<Member, Integer> votes = votingService.askForVote(members, scanner);

                System.out.println("Votos conseguidos: " + formatVote(votes));

                if(votingService.isConsensus(votes.values())){
                    int score = votingService.valueConsensus(votes.values());
                    history.setFinalScore(score);
                    System.out.println("Consenso alcanzado: " + score);
                    consensusAccomplish = true;
                } else {
                    System.out.println("Votos divergentes - discutan y vuelven a votar");
                }
            }
        }
        showSummary();
    }

    private String formatVote(Map<Member, Integer> votes){
        StringBuilder sb = new StringBuilder();     
        sb.append("[");
        boolean first = true;
        for(Map.Entry<Member, Integer> e : votes.entrySet()){
            if(!first) sb.append(", ");
            sb.append(e.getKey().getName()).append(": ").append(e.getValue());
            first = false;
        }
        sb.append(" ]");
        return sb.toString();
    }

    private void showSummary(){
        System.out.println("Resumen de estimaciones de historias: ");
        for(History h : stories){
            System.out.println(h);
        }
    }
    
}
