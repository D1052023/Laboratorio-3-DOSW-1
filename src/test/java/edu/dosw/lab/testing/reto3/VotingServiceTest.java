package edu.dosw.lab.testing.reto3;

import edu.dosw.lab.agilismo.Reto3.Member;
import org.junit.jupiter.api.Test;
import edu.dosw.lab.agilismo.Reto3.VotingService;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


class VotingServiceTest {

    @Test
    void shouldReturnValidVoteWhenInputValid() {
        VotingService vs = new VotingService();
        Member m = new Member("Robinson Nuñez");
        Scanner scanner = new Scanner("5\n");
        int vote = vs.askForVoteMember(m, scanner);
        assertEquals(5, vote);
    }

    @Test
    void shouldSkipInvalidAndReturnFirstValid() {
        VotingService vs = new VotingService();
        Member m = new Member("Juan Pablo");
        Scanner scanner = new Scanner("No compila\n4\n3\n");
        int vote = vs.askForVoteMember(m, scanner);
        assertEquals(3, vote);
    }

    @Test
    void shouldReturnMapPreservingOrder(){
        VotingService vs = new VotingService();
        Member robinson = new Member("Robinson Nuñez");
        Member oscar = new Member("Oscar Sanchez");
        List<Member> members = Arrays.asList(robinson, oscar);

        Scanner scanner = new Scanner("1\n13\n");
        Map<Member, Integer> votes = vs.askForVote(members, scanner);

        Iterator<Map.Entry<Member, Integer>> it = votes.entrySet().iterator();
        Map.Entry<Member, Integer> e1 = it.next();
        Map.Entry<Member, Integer> e2 = it.next();

        assertEquals(robinson, e1.getKey());
        assertEquals(Integer.valueOf(1), e1.getValue());

        assertEquals(oscar, e2.getKey());
        assertEquals(Integer.valueOf(13), e2.getValue());
        assertEquals(2, votes.size());
    }

    @Test
    void shouldReturnTrueWhenAllEqual() {
        VotingService vs = new VotingService();
        boolean ok = vs.isConsensus(Arrays.asList(5, 5, 5));
        assertTrue(ok);
    }

    @Test
    void shouldReturnFalseWhenDifferent() {
        VotingService vs = new VotingService();
        boolean ok = vs.isConsensus(Arrays.asList(3, 5, 3));
        assertFalse(ok);
    }

    @Test
    void shouldReturnConsensusValue() {
        VotingService vs = new VotingService();
        int val = vs.valueConsensus(Arrays.asList(8, 8, 8));
        assertEquals(8, val);
    }

    @Test
    void shouldReturnFirstElementWhenNotConsensus() {
        VotingService vs = new VotingService();
        int val = vs.valueConsensus(Arrays.asList(2, 3, 5));
        assertEquals(2, val);
    }
}
