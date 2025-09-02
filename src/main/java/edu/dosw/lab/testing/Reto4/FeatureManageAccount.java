package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FeatureManageAccount implements ManageAccount {
    private final Map<String, Account> accounts = new ConcurrentHashMap<>();

    @Override
    public void save(Account account) {
        if (account == null || account.getId() == null) throw new IllegalArgumentException("Account o id nulo");
        accounts.put(account.getId(), account);
    }

    @Override
    public Account findById(String id) {
        return accounts.get(id);
    }

    @Override
    public boolean existsById(String id) {
        return accounts.containsKey(id);
    }

    @Override
    public List<Account> findAll() {
        return accounts.values().stream().collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Transaction depositToAccount(String accountId, BigDecimal amount) {
        if (amount == null) throw new IllegalArgumentException("amount null");
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("amount must be > 0");


        try {
            accounts.compute(accountId, (k, existing) -> {
                if (existing == null) {
                    throw new IllegalArgumentException("Cuenta no encontrada: " + accountId);
                }
                existing.setBalance(existing.getBalance().add(amount));
                return existing;
            });
        } catch (IllegalArgumentException e) {
            throw e;
        }

        return new Transaction(java.util.UUID.randomUUID().toString(), amount, null, accountId);
    }
}