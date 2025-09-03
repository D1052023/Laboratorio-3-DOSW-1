package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;

/**
 * Representa una cuenta bancaria con informacion basica
 */
public class Account {
    private String id;
    private String email;
    private String fullName;
    private BigDecimal balance;

    /**
     * Crea una cuenta con saldo inicial cero
     */
    public Account() {
        this.balance = BigDecimal.ZERO;
    }

    /**
     * Crea una cuenta con los datos especificados
     *
     * @param id  identificador único de la cuenta
     * @param email  correo electrónico del titular
     * @param fullName  nombre completo del titular
     * @param balance saldo inicial
     */
    public Account(String id, String email, String fullName, BigDecimal balance) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.balance = balance != null ? balance : BigDecimal.ZERO;
    }
    /**
     * Obtiene el identificador de la cuenta
     *
     * @return id de la cuenta
     */
    public String getId() {
        return id;
    }
    /**
     * Establece el identificador de la cuenta
     * @param id nuevo identificador
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene el correo electronico del titular
     * @return email del titular
     */
    public String getEmail() {
        return email;
    }
    /**
     * Establece el correo electronico del titula
     * @param email nuevo correo electronico
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obtiene el nombre completo del titular
     * @return nombre completo
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Establece el nombre completo del titular
     * @param fullName nuevo nombre completo
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * Obtiene el saldo actual de la cuenta
     * @return saldo de la cuenta
     */
    public BigDecimal getBalance() {
        return balance;
    }
    /**
     * Establece el saldo de la cuenta
     * @param balance nuevo saldo
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}