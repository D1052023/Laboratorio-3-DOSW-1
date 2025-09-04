package edu.dosw.lab.testing.reto3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.agilismo.Reto3.History;


public class HistoryTest {

    @Test
    void testConstructorHistoryAndGetters(){
        History history = new History(1, "Juan Caballero", "Como cliente quiero conocer el saldo de mi cuenta");

        assertEquals(1, history.getId());
        assertEquals("Como cliente quiero conocer el saldo de mi cuenta", history.getDescription());
    }

    @Test
    void shouldPassConstructorWithNulls() {
        History history = new History(2, null, null);

        assertEquals(2, history.getId());
        assertEquals("", history.getDescription());
    }

    @Test
    void shouldSetFinalScoreAndToString() {
        History history = new History(3, "Robinson Portela", "Como cliente quiero agreagar una cuenta bancaria");

        String expectedBefore = "3: Robinson Portela - Como cliente quiero agreagar una cuenta bancaria- Estimación final: No asignada";
        assertEquals(expectedBefore, history.toString());

        history.setFinalScore(13);
        String expectedAfter = "3: Robinson Portela - Como cliente quiero agreagar una cuenta bancaria- Estimación final: 13";
        assertEquals(expectedAfter, history.toString());
    }

}