package edu.dosw.lab.testing.reto4;


import edu.dosw.lab.testing.Reto4.Transaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    @Test
    void shouldCreateTransactionWithDefaults() {
        Transaction tx = new Transaction("1", BigDecimal.TEN, "123", "456");
        assertEquals("1", tx.getId());
        assertEquals(BigDecimal.TEN, tx.getAmount());
        assertEquals("123", tx.getOriginAccountId());
        assertEquals("456", tx.getDestinationAccountId());
        assertEquals('P', tx.getStatus(), "Estado inicial debe ser P");
        assertNotNull(tx.getDate());
    }

    @Test
    void shouldAllowUpdatingDate() {
        Transaction tx = new Transaction("1", BigDecimal.ONE, "123", "456");
        LocalDate newDate = LocalDate.of(2025, 1, 1);
        tx.setAmount(newDate);
        assertEquals(newDate, tx.getDate(), "Debe permitir actualizar la fecha");
    }

    @Test
    void shouldAllowUpdatingOriginAndDestination() {
        Transaction tx = new Transaction("1", BigDecimal.ONE, "123", "456");
        tx.setOriginAccountId("999");
        tx.setDestinationAccountId("888");
        assertEquals("999", tx.getOriginAccountId());
        assertEquals("888", tx.getDestinationAccountId());
    }
}