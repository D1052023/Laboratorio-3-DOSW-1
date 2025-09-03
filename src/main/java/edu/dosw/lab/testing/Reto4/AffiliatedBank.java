package edu.dosw.lab.testing.Reto4;

/**
 * Bancos afiliados al sistema.
 * Cada banco cuenta con un nombre y un codigo unico
 */
public enum AffiliatedBank {
    BANCO_1("BANCOLOMBIA", "01"),
    BANCO_2("DAVIVIENDA", "02");

    private final String name;
    private final String code;

    /**
     * Constructor de la enumeracion
     * @param name 
     * @param code 
     */
    AffiliatedBank(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * Método que obtiene el nombre del banco
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * Método que obtiene el codigo del banco
     * @return 
     */
    public String getCode() {
        return code;
    }

    /**
     * Método que verifica si existe un banco afiliado con el codigo proporcionado
     * @param code 
     * @return 
     */
    public static boolean exists(String code) {
        for (AffiliatedBank bank : values()) {
            if (bank.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
}