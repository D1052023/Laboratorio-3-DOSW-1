package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa una transacción bancaria.
 * Principio SRP: solo gestiona datos de una operación (depósito, transferencia, etc.).
 */
public class Transaction {
    private String id;
    private BigDecimal amount;
    private LocalDate date;
    private String originAccountId;
    private String destinationAccountId;
    private char status;

    public Transaction(String id, BigDecimal amount, String originAccountId, String destinationAccountId) {
        this.id = id;
        this.amount = amount;
        this.date = LocalDate.now();
        this.originAccountId = originAccountId;
        this.destinationAccountId = destinationAccountId;
        this.status = 'P';
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public BigDecimal SetAmount(LocalDate date) {
        this.date = date;
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getOriginAccountId() {
        return originAccountId;
    }
    public String setOriginAccountId(String originAccountId) {
        this.originAccountId = originAccountId;
        return this.originAccountId;
    }

    public String getDestinationAccountId() {
        return destinationAccountId;
    }
    public   String setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
        return this.destinationAccountId;
    }

    public char getStatus() {
        return status;
    }
}
