package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.*;

public class BANKIFY {
    private String name;
    private String id;
    private List<AffiliatedBank> affiliatedBanks = new ArrayList<>();
    private BigDecimal balance;
    private String source;
    private Map<String, Account> accounts;

    public BANKIFY() {
        this.accounts = new HashMap<>();
    }

    public BANKIFY(String name, String id, List<AffiliatedBank> affiliatedBanks, BigDecimal balance, String source) {
        this.name = name;
        this.id = id;
        this.affiliatedBanks = affiliatedBanks != null ? affiliatedBanks : new ArrayList<>();
        this.balance = balance != null ? balance : BigDecimal.ZERO;
        this.source = source;
    }


    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public String getName() { return name; }

    public String getId() { return id; }

    public List<AffiliatedBank> getAffiliatedBanks() { return affiliatedBanks; }
    public void setAffiliatedBanks(List<AffiliatedBank> affiliatedBanks) {
        this.affiliatedBanks = affiliatedBanks != null ? affiliatedBanks : new ArrayList<>();
    }

    public BigDecimal getBalance(String accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new NoSuchElementException("Cuenta no encontrada: " + accountId);
        }
        return account.getBalance();
    }

    public void setBalance(String accountId, BigDecimal newBalance) {
        Account account = accounts.get(accountId);
        account.setBalance(newBalance);
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

}
