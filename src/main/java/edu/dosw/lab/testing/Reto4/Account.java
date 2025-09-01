package edu.dosw.lab.testing.Reto4;

import edu.dosw.lab.testing.Reto4.Transaction;

import java.math.BigDecimal;

/**
 * Entidad Account (modelo).
 * Atributos y métodos básicos con getters/setters.
 */
public class Account {
    private String id;
    private String email;
    private String fullName;
    private BigDecimal balance;

    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    public Account(String id, String email, String fullName, BigDecimal balance) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal balance) { this.balance = balance; }

}