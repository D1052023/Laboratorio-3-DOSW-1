package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase que maneja la función de la cuenta
 */
public class FeatureManageAccount implements ManageAccount {

    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    /**
     * Método que guarda una cuenta en memoria.
     * @param account
     * @throws IllegalArgumentException
     */
    @Override
    public void save(Account account) {
        Optional.ofNullable(account)
                .map(Account::getId)
                .orElseThrow(() -> new IllegalArgumentException("Account o id nulo"));
        accounts.put(account.getId(), account);
    }

    /**
     * Método que busca una cuenta en memoria por su identificador.
     * @param id 
     * @return 
     */
    @Override
    public Account findById(String id) {
        return accounts.get(id);
    }

    /**
     * Método que verifica si existe una cuenta con el id dado
     * @param id 
     * @return 
     */
    @Override
    public boolean existsById(String id) {
        return accounts.containsKey(id);
    }

    /**
     * Método que obtiene todas las cuentas almacenadas en memoria.
     * @return 
     */
    @Override
    public List<Account> findAll() {
        return accounts.values().stream().toList(); 
    }

    /**
     * Método que realiza un depósito en una cuenta existente.
     * @param accountId 
     * @param amount   
     * @return 
     * @throws IllegalArgumentException 
     *                                  
     */
    @Override
    public Transaction depositToAccount(String accountId, BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }

        Account updated = Optional.ofNullable(accounts.computeIfPresent(accountId, (k, existing) -> {
            existing.setBalance(existing.getBalance().add(amount));
            return existing;
        })).orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada: " + accountId));

        return new Transaction(UUID.randomUUID().toString(), amount, null, updated.getId());
    }
}