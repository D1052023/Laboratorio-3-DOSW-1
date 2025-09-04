package edu.dosw.lab.testing.reto3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.agilismo.Reto3.Member;

public class MemberTest {

    @Test
    void testConstructorMemberAndGetters(){
        Member member = new Member("Juan Caballero", 2);
        Member member0 = new Member("Oscar Sanchez");
        Member member1 = new Member("Robinson Portela", 8);
        Member member2 = new Member("Juan Manuel");

        assertEquals("Juan Caballero", member.getName());
        assertEquals("Oscar Sanchez", member0.getName());
        assertEquals("Robinson Portela", member1.getName());
        assertEquals("Juan Manuel", member2.getName());

        assertEquals(2, member.getVote());
        assertEquals(8, member1.getVote());
       
        assertThrows(IllegalArgumentException.class, () -> {
        new Member("Oscar Sanchez", -5);
    });

    assertThrows(IllegalArgumentException.class, () -> {
        new Member("Juan Manuel", -22);
    });

    }

    @Test
    void shouldPassConstructorWithName() {
        Member member = new Member("Juan Caballero");

        assertEquals("Juan Caballero", member.getName());
        assertEquals(-1, member.getVote()); 
    }

    @Test
    void shouldSetVote(){
        Member member = new Member("Juan Caballero");

        assertEquals(-1, member.getVote());

        member.setVote(13);
        assertEquals(13, member.getVote());
    }

    @Test
    void shouldSetInvalidVote() {
        Member member = new Member("Oscar Andres");

        assertThrows(IllegalArgumentException.class, () -> {
            member.setVote(4);
        });
    }

    @Test
    void shouldBeRestartVote() {
        Member member = new Member("Robinson Nuñez", 3);

        assertEquals(3, member.getVote());

        member.restartVote();
        assertEquals(-1, member.getVote());
    }
}