package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Clase que gestiona las operaciones sobre cuentas:
 * creación, consulta de saldo y depósitos.
 */
public class AccountService {
    private final ManageAccount manageAccounts;
    private final AccountValidator validator;

    /**
     * Constructor de AccountService.
     * @param manageAccounts 
     * @param validator
     */
    public AccountService(ManageAccount manageAccounts, AccountValidator validator) {
        this.manageAccounts = Objects.requireNonNull(manageAccounts);
        this.validator = Objects.requireNonNull(validator);
    }

    /**
     * Crea una nueva cuenta si es válida y no existe previamente.
     * @param id 
     * @param email 
     * @param fullName 
     * @param balance 
     * @return 
     * @throws IllegalArgumentException 
     * @throws IllegalStateException 
     */
    public Account createAccount(String id, String email, String fullName, BigDecimal balance) {
        Account acc = new Account(id, email, fullName, BigDecimal.ZERO);
        if (!validator.isValid(acc)) {
            throw new IllegalArgumentException("Cuenta invalida");
        }
        if (manageAccounts.existsById(id)) {
            throw new IllegalStateException("Cuenta ya existe: " + id);
        }
        manageAccounts.save(acc);
        return acc;
    }

    /**
     * Obtiene el saldo de una cuenta existente
     * @param id 
     * @return 
     * @throws IllegalArgumentException 
     */
    public BigDecimal getBalance(String id) {
        return Optional.ofNullable(manageAccounts.findById(id))
                .map(Account::getBalance)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + id));

    }

    /**
     * Realiza un depósito en una cuenta
     * @param accountId 
     * @param amount 
     * @return
     */
    public Transaction deposit(String accountId, BigDecimal amount) {
        Objects.requireNonNull(amount, "amount es null");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        return manageAccounts.depositToAccount(accountId, amount);
    }

    /**
     * Lista todas las cuentas registradas.
     * @return 
     */
    public List<Account> listAccounts() {
        return manageAccounts.findAll();
    }
}