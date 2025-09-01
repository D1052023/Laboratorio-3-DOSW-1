package edu.dosw.lab.testing.Reto4;

/**
 * Enum que representa los bancos afiliados
 */
public enum AffiliatedBank {
    BANCO_1("BANCOLOMBIA", "01"),
    BANCO_2("DAVIVIENDA", "02");

    private final String name;
    private final String code;

    AffiliatedBank(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
