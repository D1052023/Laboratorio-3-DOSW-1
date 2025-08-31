package edu.dosw.lab.agilismo.Reto3;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VotingService {
    private static final List<Integer> fibonacci = Arrays.asList(1, 2, 3, 5, 8 ,13);

    public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner){
        Map<Member, Integer> votes = new LinkedHashMap<>();
        for(Member member : members){
            int vote = askForVoteMember(member, scanner);
            votes.put(member, vote);
        }
        return votes;
    }

    public int askForVoteMember(Member member, Scanner scanner){
        while(true) {
            System.out.print("Ingrese voto de" + member.getName() + " (1,2,3,5,8,13): ");
            String input = scanner.nextLine().trim();
            try{
                int vo = Integer.parseInt(input);
                if(fibonacci.contains(vo)) return vo;
            } catch(NumberFormatException ignored){}
            System.out.println("Voto inválido. Use uno de: " + fibonacci);
        }
    }

    public boolean isConsensus(Collection<Integer> votes){
        return votes.stream().distinct().count() == 1;
    }

    public int valueConsensus(Collection<Integer> votes){
        return votes.iterator().next();
    }

}
