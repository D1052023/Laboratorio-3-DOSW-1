package edu.dosw.lab.testing.Reto4;

import java.math.BigDecimal;
import java.util.*;

/**
 * Clase que gestiona funcionalidades
 */
public class BANKIFY {

    private String name;
    private String id;
    private List<AffiliatedBank> affiliatedBanks = new ArrayList<>();
    private BigDecimal balance;
    private String source;
    private Map<String, Account> accounts;

    /**
     * Crea una instancia de BANKIFY sin datos iniciales y con mapa vacio de cuentas
     */
    public BANKIFY() {
        this.accounts = new HashMap<>();
    }
    /**
     * Contructor de BANKIFY
     * @param name 
     * @param id 
     * @param affiliatedBanks  
     * @param balance 
     * @param source 
     */
    public BANKIFY(String name, String id, List<AffiliatedBank> affiliatedBanks, BigDecimal balance, String source) {
        this.name = name;
        this.id = id;
        this.affiliatedBanks = affiliatedBanks != null ? affiliatedBanks : new ArrayList<>();
        this.balance = balance != null ? balance : BigDecimal.ZERO;
        this.source = source;
        this.accounts = new HashMap<>();
    }

    /**
     * Método que agrega una cuenta a la plataforma
     * @param account 
     */
    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    /**
     * Método que obtiene el nombre de la plataforma
     * @return 
     */
    public String getName() { return name; }

    /**
     * Método que obtiene el identificador de la plataforma
     * @return 
     */
    public String getId() { return id; }

    /**
     * Método que obtiene la lista de bancos afiliados
     * @return 
     */
    public List<AffiliatedBank> getAffiliatedBanks() { return affiliatedBanks; }

    /**
     * Método que establece la lista de bancos afiliados
     * @param affiliatedBanks 
     */
    public void setAffiliatedBanks(List<AffiliatedBank> affiliatedBanks) {
        this.affiliatedBanks = affiliatedBanks != null ? affiliatedBanks : new ArrayList<>();
    }

    /**
     * Método que obtiene el saldo de una cuenta registrada
     * @param accountId 
     * @return 
     */
    public BigDecimal getBalance(String accountId) {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new NoSuchElementException("Cuenta no encontrada: " + accountId);
        }
        return account.getBalance();
    }

    /**
     * Método que actualiza el saldo de una cuenta registrada
     * @param accountId  
     * @param newBalance 
     */
    public void setBalance(String accountId, BigDecimal newBalance) {
        Account account = accounts.get(accountId);
        if (account == null) {
            throw new NoSuchElementException("Cuenta no encontrada: " + accountId);
        }
        account.setBalance(newBalance);
    }

    /**
     * Método que obtiene la fuente de creacion o registro
     * @return 
     */
    public String getSource() { return source; }

    /**
     * Método que establece la fuente de creacion o registro
     * @param source 
     */
    public void setSource(String source) { this.source = source; }

}