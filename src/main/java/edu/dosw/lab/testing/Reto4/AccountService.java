package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.*;

public class AccountService {
    private final ManageAccount manageAccounts;
    private final AccountValidator validator;

    public AccountService(ManageAccount manageAccounts, AccountValidator validator) {
        this.manageAccounts = Objects.requireNonNull(manageAccounts);
        this.validator = Objects.requireNonNull(validator);
    }

    public Account createAccount(String id, String email, String fullName) {
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

    public BigDecimal getBalance(String id) {
        Account acc = manageAccounts.findById(id);
        if (acc == null) throw new IllegalArgumentException("Cuenta no encontrada: " + id);
        return acc.getBalance();
    }

    public Transaction deposit(String accountId, BigDecimal amount) {
        Objects.requireNonNull(amount, "amount es null");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        return manageAccounts.depositToAccount(accountId, amount);
    }


    public List<Account> listAccounts() {
        return manageAccounts.findAll();
    }
}
