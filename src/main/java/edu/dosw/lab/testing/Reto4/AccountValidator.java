package edu.dosw.lab.testing.Reto4;

import java.util.regex.Pattern;

/**
 * Claseque permite validar una cuenta
 */
public class AccountValidator {
    private static final Pattern emailPattern =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    private static final Pattern accountPattern =
            Pattern.compile("^\\d{10}$"); 

    /**
     * Método que valida si una cuenta cumple con ciertas reglas.
     * @param account
     * @return
     */
    public boolean isValid(Account account) {
        if (account == null) return false;

        // calida el numero de la cuenta
        String id = account.getId();
        if (id == null || !accountPattern.matcher(id).matches()) {
            return false;
        }

        // Validar el codigo del banco afiliado
        String bankCode = id.substring(0, 2);
        if (!AffiliatedBank.exists(bankCode)) {
            return false;
        }

        // Validar email
        String email = account.getEmail();
        if (email == null || !emailPattern.matcher(email).matches()) {
            return false;
        }

        // Validar nombre
        String name = account.getFullName();
        if (name == null || name.isBlank()) {
            return false;
        }

        return true;
    }
    
}
