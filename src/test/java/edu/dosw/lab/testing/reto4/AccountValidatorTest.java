package edu.dosw.lab.testing.reto4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.dosw.lab.testing.Reto4.Account;
import edu.dosw.lab.testing.Reto4.AccountValidator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;


class AccountValidatorTest {

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
        Account account = new Account(null, "user@mail.com", "Juan Pablo", BigDecimal.TEN);
        assertFalse(validator.isValid(account));
    }

    @Test
    void shouldFailWhenEmailIsInvalid() {
        Account account = new Account("1", "email_invalido", "Juan Pablo", BigDecimal.TEN);
        assertFalse(validator.isValid(account));
    }

    @Test
    void shouldFailWhenNameIsEmpty() {
        Account account = new Account("01", "escuelaing@mail.com", "", BigDecimal.TEN);
        assertFalse(validator.isValid(account));
    }

    @Test
    void shouldBeValidAccount() {
        Account account = new Account("0100456789", "escuelaing@mail.com", "Juan Pablo", BigDecimal.valueOf(100));
        assertTrue(validator.isValid(account));
    }

}