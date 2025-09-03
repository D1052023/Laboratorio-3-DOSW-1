package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Clase que representa una transaccion bancaria entre dos cuentas
 */
public class Transaction {

    private String id;
    private BigDecimal amount;
    private LocalDate date;
    private String originAccountId;
    private String destinationAccountId;
    private char status;
    /**
     * Constructor de Transaction
     * @param id  
     * @param amount 
     * @param originAccountId  
     * @param destinationAccountId 
     */
    public Transaction(String id, BigDecimal amount, String originAccountId, String destinationAccountId) {
        this.id = id;
        this.amount = amount;
        this.date = LocalDate.now();
        this.originAccountId = originAccountId;
        this.destinationAccountId = destinationAccountId;
        this.status = 'P';
    }
    /**
     * Método que obtiene el identificador de la transaccion
     * @return 
     */
    public String getId() {
        return id;
    }
    /**
     * Método que obtiene el monto de la transaccion
     * @return 
     */
    public BigDecimal getAmount() {
        return amount;
    }
    /**
     * Método que asigna la fecha de la transaccion
     * @param date 
     * @return 
     */
    public BigDecimal setAmount(LocalDate date) {
        this.date = date;
        return amount;
    }
    /**
     * Método que obtiene la fecha de la transaccion
     * @return 
     */
    public LocalDate getDate() {
        return date;
    }
    /**
     * Método que obtiene la cuenta de origen
     * @return 
     */
    public String getOriginAccountId() {
        return originAccountId;
    }
    /**
     * Método que establece la cuenta de origen
     * @param originAccountId 
     * @return 
     */
    public String setOriginAccountId(String originAccountId) {
        this.originAccountId = originAccountId;
        return this.originAccountId;
    }
    /**
     * Método que obtiene la cuenta de destino
     * @return 
     */
    public String getDestinationAccountId() {
        return destinationAccountId;
    }
    /**
     * Método que establece la cuenta de destino
     * @param destinationAccountId 
     * @return
     */
    public String setDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
        return this.destinationAccountId;
    }
    /**
     * Método que obtiene el estado de la transaccion
     * @return 
     */
    public char getStatus() {
        return status;
    }
}