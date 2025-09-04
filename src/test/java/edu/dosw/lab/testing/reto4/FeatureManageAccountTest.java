package edu.dosw.lab.testing.reto4;

import edu.dosw.lab.testing.Reto4.Account;
import edu.dosw.lab.testing.Reto4.FeatureManageAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class FeatureManageAccountTest {

    private FeatureManageAccount manager;

    @BeforeEach
    void setUp() {
        manager = new FeatureManageAccount();
    }

    @Test
    void shouldSaveAndFindAccount() {
        Account acc = new Account(
                "1000100575",
                "robinson.nunez-p@mail.escuelaing.edu.co",
                "ROBINSON STEVEN NUÑEZ PORTELA",
                BigDecimal.TEN
        );

        manager.save(acc);
        assertTrue(manager.existsById("1000100575"));
        assertEquals(acc, manager.findById("1000100575"));
    }


    @Test
    void shouldReturnEmptyWhenAccountDoesNotExist() {
        assertNull(manager.findById("9999999999"));
    }


    @Test
    void shouldReturnAllAccounts() {
        manager.save(new Account("1000100279", "oscar.sporras@mail.escuelaing.edu.co", "oscar andres sanchez porras", BigDecimal.ONE));
        manager.save(new Account("1000100516", "juan.ccastellanos@mail.escuelaing.edu.co", "JUAN PABLO CABALLERO CASTELLANOS", BigDecimal.TEN));
        assertEquals(2, manager.findAll().size());
    }

    @Test
    void shouldDepositSuccessfully() {
        Account acc = new Account("1000100516", "juan.ccastellanos@mail.escuelaing.edu.co", "JUAN PABLO CABALLERO CASTELLANOS", BigDecimal.ZERO);
        manager.save(acc);
        manager.depositToAccount("1000100516", BigDecimal.valueOf(1000));
        assertEquals(BigDecimal.valueOf(1000), acc.getBalance());
    }

    @Test
    void shouldFailDepositWhenAccountDoesNotExist() {
        assertThrows(IllegalArgumentException.class,
                () -> manager.depositToAccount("1000100516", BigDecimal.valueOf(1000)));
    }

    @Test
    void shouldFailDepositWhenAmountInvalid() {
        Account acc = new Account("1000100372", "juan.cllanos@mail.escuelaing.edu.co", "Juan castañeda", BigDecimal.ZERO);
        manager.save(acc);
        assertThrows(IllegalArgumentException.class,
                () -> manager.depositToAccount("100010037", BigDecimal.ZERO));
    }
    @Test
    void shouldAccumulateDepositsCorrectly() {
        Account acc = new Account("1000100342", "pablo.rodriguez@mail.escuelaing.edu.co", "pablo rodriguez", BigDecimal.ZERO);
        manager.save(acc);

        manager.depositToAccount("1000100342", BigDecimal.valueOf(100));
        manager.depositToAccount("1000100342", BigDecimal.valueOf(200));

        assertEquals(BigDecimal.valueOf(300), acc.getBalance(),
                "El balance debe acumular múltiples depósitos");
    }

    @Test
    void shouldFailDepositWhenAmountIsNull() {
        Account acc = new Account("1000100575", "robinson.nunez-p@mail.escuelaing.edu.co", "ROBINSON STEVEN NUÑEZ PORTELA", BigDecimal.ZERO);
        manager.save(acc);

        assertThrows(IllegalArgumentException.class,
                () -> manager.depositToAccount("100010057", null),
                "Debe fallar si el monto es nulo");
    }

    @Test
    void shouldReturnTransactionOnDeposit() {
        Account acc = new Account("1000122575", "juan.nunez-p@mail.escuelaing.edu.co", "juan nuñez PORTELA", BigDecimal.ZERO);
        manager.save(acc);

        var tx = manager.depositToAccount("1000122575", BigDecimal.valueOf(500));

        assertNotNull(tx, "El depósito debe devolver una transacción válida");
        assertEquals(BigDecimal.valueOf(500), tx.getAmount(),
                "La transacción debe reflejar el monto del depósito");
        assertEquals("1000122575", tx.getDestinationAccountId(),
                "La transacción debe guardar la cuenta destino");
        assertEquals('P', tx.getStatus(),
                "El estado inicial de la transacción debe ser P (Pending)");
    }

}