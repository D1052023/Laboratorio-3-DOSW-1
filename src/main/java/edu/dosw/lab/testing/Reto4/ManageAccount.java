package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interfaz que maneja la cuenta
 */
interface ManageAccount {
    void save(Account account);
    Account findById(String id);
    boolean existsById(String id);
    List<Account> findAll();
    Transaction depositToAccount(String accountId, BigDecimal amount);
}