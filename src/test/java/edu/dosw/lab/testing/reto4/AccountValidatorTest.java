package edu.dosw.lab.testing.reto4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.testing.Reto4.Account;
import edu.dosw.lab.testing.Reto4.AccountValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;


public class AccountValidatorTest {

    private AccountValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AccountValidator();
    }

    @Test
    void shouldFailWhenAccountIsNull() {
        assertFalse(validator.isValid(null), "Una cuenta nula no debe ser valida");
    }

    @Test
    void shouldFailWhenIdIsMissing() {
        Account account = new Account(null, "robinson.nunez-p@mail.escuelaing.edu.co", "ROBINSON STEVEN NUÑEZ PORTELA", BigDecimal.TEN);
        assertFalse(validator.isValid(account));
    }

    @Test
    void shouldFailWhenEmailIsInvalid() {
        Account account = new Account("1000100575", "email_invalido", "ROBINSON STEVEN NUÑEZ PORTELA", BigDecimal.TEN);
        assertFalse(validator.isValid(account));
    }

    @Test
    void shouldFailWhenNameIsEmpty() {
        Account account = new Account("1000100575", "robinson.nunez-p@mail.escuelaing.edu.co", "", BigDecimal.TEN);
        assertFalse(validator.isValid(account));
    }

    @Test
    void shouldBeValidAccount() {
        Account account = new Account("0100456789", "juan.nunez-p@mail.escuelaing.edu.co", "Juan Pablo nuñez", BigDecimal.valueOf(100));
        assertTrue(validator.isValid(account));
    }
    @Test
    void shouldFailWhenNameIsNull() {
        Account account = new Account("1000100722", "juan.nunez-p@mail.escuelaing.edu.co", null, BigDecimal.TEN);
        assertFalse(validator.isValid(account), "El nombre nulo no debe ser válido");
    }

    @Test
    void shouldFailWhenEmailIsNull() {
        Account account = new Account("1000100722", null, "Juan Pablo", BigDecimal.TEN);
        assertFalse(validator.isValid(account), "El email nulo no debe ser válido");
    }

    @Test
    void shouldFailWhenBalanceIsNegative() {
        Account account = new Account("1000100722", "juan.nunez-p@mail.escuelaing.edu.co", "Juan Pablo nuñez", BigDecimal.valueOf(-100));
        assertFalse(validator.isValid(account), "El balance negativo no debe ser válido");
    }

    @Test
    void shouldFailWhenIdIsEmpty() {
        Account account = new Account("", "juan.nunez-p@mail.escuelaing.edu.co", "Juan Perez nunez", BigDecimal.TEN);
        assertFalse(validator.isValid(account), "La cuenta no debe ser válida si el id es vacío");
    }
}