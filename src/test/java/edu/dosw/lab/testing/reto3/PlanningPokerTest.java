package edu.dosw.lab.testing.reto3;

import edu.dosw.lab.agilismo.Reto3.History;
import edu.dosw.lab.agilismo.Reto3.Member;
import edu.dosw.lab.agilismo.Reto3.PlanningPoker;
import edu.dosw.lab.agilismo.Reto3.VotingService;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
public class PlanningPokerTest {

    private final Member Juan = new Member("Juan Pablo");
    private final Member Oscar = new Member("Oscar Sanchez");
    private final List<Member> members = Arrays.asList(Juan, Oscar);


    @Test
    void shouldConsensusReachedOnFirstRound() {
        History story = new History(5, "Banco", "Como banco, quiero proveer los códigos de cuenta válidos, para que el sistema pueda crear cuentas correctamente.");
        List<History> stories = Collections.singletonList(story);

        VotingService stub = new VotingService() {
            @Override
            public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) {
                Map<Member, Integer> votes = new LinkedHashMap<>();
                votes.put(Juan, 8);
                votes.put(Oscar, 8);
                return votes;
            }
            @Override public boolean isConsensus(Collection<Integer> votes) { return true; }
            @Override public int valueConsensus(Collection<Integer> votes) { return 8; }
        };

        PlanningPoker pp = new PlanningPoker(stories, members, stub);
        pp.login(new Scanner(""));
        assertEquals(Integer.valueOf(8), story.getFinalScore());
    }

    @Test
    void shouldDivergentThenConsensus() {
        History story = new History(3, "Cliente", "Como cliente, quiero validar/verificar mi número de cuenta antes de crearla, para asegurar que tiene el formato correcto y pertenece a un banco registrado.");
        List<History> stories = Collections.singletonList(story);

        VotingService stub = new VotingService() {
            int call = 0;
            @Override
            public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) {
                call++;
                Map<Member, Integer> votes = new LinkedHashMap<>();
                if (call == 1) { votes.put(Juan, 13); votes.put(Oscar, 5); }
                else { votes.put(Juan, 13); votes.put(Oscar, 13); }
                return votes;
            }
            @Override public boolean isConsensus(Collection<Integer> votes) {
                Set<Integer> s = new HashSet<>(votes);
                return s.size() == 1;
            }
            @Override public int valueConsensus(Collection<Integer> votes) { return votes.iterator().next(); }
        };

        PlanningPoker pp = new PlanningPoker(stories, members, stub);
        pp.login(new Scanner(""));

        assertEquals(Integer.valueOf(13), story.getFinalScore());
    }


    @Test
    void shouldSupportMultipleStories() {
        History s1 = new History(1, "Cliente", "Como cliente, quiero consultar el saldo de mi cuenta, para saber cuánto dinero tengo disponible.");
        History s2 = new History(6, "Banco", "Como banco, quiero validar las transacciones realizadas en las cuentas, para garantizar que sean seguras y autorizadas.");
        List<History> stories = Arrays.asList(s1, s2);

        VotingService stub = new VotingService() {
            int idx = 0;
            @Override
            public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) {
                Map<Member, Integer> map = new LinkedHashMap<>();
                if (idx == 0) { map.put(Juan, 1); map.put(Oscar, 1); }
                else { map.put(Juan, 5); map.put(Oscar, 5); }
                idx++;
                return map;
            }
            @Override public boolean isConsensus(Collection<Integer> votes) { return true; }
            @Override public int valueConsensus(Collection<Integer> votes) { return votes.iterator().next(); }
        };

        PlanningPoker pp = new PlanningPoker(stories, members, stub);
        pp.login(new Scanner(""));

        assertEquals(Integer.valueOf(1), s1.getFinalScore());
        assertEquals(Integer.valueOf(5), s2.getFinalScore());
    }


    @Test
    void shouldPropagatesVotingServiceException() {
        History s = new History(4, "Cliente", "Como cliente, quiero realizar depósitos en mi cuenta, para aumentar el saldo disponible.");
        List<History> stories = Collections.singletonList(s);

        VotingService stub = new VotingService() {
            @Override
            public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) {
                throw new RuntimeException("simulated failure");
            }
        };

        PlanningPoker pp = new PlanningPoker(stories, members, stub);
        assertThrows(RuntimeException.class, () -> pp.login(new Scanner("")));
    }

    @Test
    void shouldAskForVoteInvocationCount() {
        History s = new History(4, "Cliente", "Como cliente, quiero realizar depósitos en mi cuenta, para aumentar el saldo disponible.");
        List<History> stories = Collections.singletonList(s);

        class CountingVotingService extends VotingService {
            int calls = 0;
            @Override
            public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) {
                calls++;
                Map<Member, Integer> m = new LinkedHashMap<>();
                m.put(Juan, 2); m.put(Oscar, 2);
                return m;
            }
            @Override public boolean isConsensus(Collection<Integer> votes) { return true; }
            @Override public int valueConsensus(Collection<Integer> votes) { return 2; }
        }

        CountingVotingService counting = new CountingVotingService();
        PlanningPoker pp = new PlanningPoker(stories, members, counting);
        pp.login(new Scanner(""));

        assertTrue(counting.calls >= 1);
    }

    @Test
    void shouldDoNothingWithoutStories() {
        List<History> empty = Collections.emptyList();
        VotingService stub = new VotingService() {
            @Override public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) { return Collections.emptyMap(); }
            @Override public boolean isConsensus(Collection<Integer> votes) { return true; }
            @Override public int valueConsensus(Collection<Integer> votes) { return 0; }
        };
        PlanningPoker pp = new PlanningPoker(empty, members, stub);
        pp.login(new Scanner(""));
    }


    @Test
    void shouldFinalScoreMatchesValueConsensus() {
        History story = new History(6, "Banco", "Como banco, quiero validar las transacciones realizadas en las cuentas, para garantizar que sean seguras y autorizadas.");
        List<History> stories = Collections.singletonList(story);

        VotingService stub = new VotingService() {
            @Override
            public Map<Member, Integer> askForVote(List<Member> members, Scanner scanner) {
                Map<Member, Integer> m = new LinkedHashMap<>();
                m.put(Juan, 1); m.put(Oscar, 1);
                return m;
            }
            @Override public boolean isConsensus(Collection<Integer> votes) { return true; }
            @Override public int valueConsensus(Collection<Integer> votes) { return 1; }
        };

        PlanningPoker pp = new PlanningPoker(stories, members, stub);
        pp.login(new Scanner(""));

        assertEquals(Integer.valueOf(1), story.getFinalScore());
    }

}