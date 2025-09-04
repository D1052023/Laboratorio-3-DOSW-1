package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.testing.Reto4.AffiliatedBank;
import edu.dosw.lab.testing.Reto4.Account;
import edu.dosw.lab.testing.Reto4.BANKIFY;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BANKIFYTest {

    @Test
    void shouldAddAccountAndGetBalance() {
        BANKIFY bankify = new BANKIFY();
        Account acc = new Account("1000100279", "oscar.sporras@mail.escuelaing.edu.co", "oscar andres sanchez porras", BigDecimal.valueOf(500));
        bankify.addAccount(acc);
        assertEquals(BigDecimal.valueOf(500), bankify.getBalance("1000100279"));
    }

    @Test
    void shouldUpdateBalanceOfExistingAccount() {
        BANKIFY bankify = new BANKIFY();
        Account acc = new Account("1000100575", "robinson.nunez-p@mail.escuelaing.edu.co", "ROBINSON STEVEN NUÑEZ PORTELA", BigDecimal.ZERO);
        bankify.addAccount(acc);
        bankify.setBalance("1000100575", BigDecimal.valueOf(200));
        assertEquals(BigDecimal.valueOf(200), bankify.getBalance("1000100575"));
    }

    @Test
    void shouldFailGetBalanceForNonExistingAccount() {
        BANKIFY bankify = new BANKIFY();
        assertThrows(NoSuchElementException.class,
                () -> bankify.getBalance("1000100575"));
    }

    @Test
    void shouldFailSetBalanceForNonExistingAccount() {
        BANKIFY bankify = new BANKIFY();
        assertThrows(NoSuchElementException.class,
                () -> bankify.setBalance("1000100575", BigDecimal.TEN));
    }

    @Test
    void shouldHandleAffiliatedBanksAndSource() {
        BANKIFY bankify = new BANKIFY();
        bankify.setAffiliatedBanks(null);
        assertTrue(bankify.getAffiliatedBanks().isEmpty());
        bankify.setSource("TestSource");
        assertEquals("TestSource", bankify.getSource());
    }
    @Test
    void shouldCreateBankifyWithConstructorAndAccessors() {
        BANKIFY bankify = new BANKIFY(
                "BankifyApp",
                "B1",
                List.of(AffiliatedBank.BANCO_1, AffiliatedBank.BANCO_2),
                BigDecimal.valueOf(1000),
                "InitSource"
        );

        assertEquals("BankifyApp", bankify.getName());
        assertEquals("B1", bankify.getId());
        assertEquals(2, bankify.getAffiliatedBanks().size());
        assertEquals("InitSource", bankify.getSource());
    }

    @Test
    void shouldSetAffiliatedBanksWithNonNullList() {
        BANKIFY bankify = new BANKIFY();
        bankify.setAffiliatedBanks(List.of(AffiliatedBank.BANCO_1));
        assertEquals(1, bankify.getAffiliatedBanks().size());
    }

}