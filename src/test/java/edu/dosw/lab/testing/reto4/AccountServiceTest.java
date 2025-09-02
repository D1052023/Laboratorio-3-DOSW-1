package edu.dosw.lab.testing.Reto4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import edu.dosw.lab.testing.Reto4.AccountValidator;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

    private AccountService accountService;
    
    @BeforeEach
    void setUp() {
        AccountValidator validator = new AccountValidator();
        FeatureManageAccount manageAccounts = new FeatureManageAccount();
        accountService = new AccountService(manageAccounts, validator);
    }

    @Test
    void shouldCreateAccountSuccessfully() {
        accountService.createAccount(
            "0110295202",
            "juancaballero@mail.com",
            "Juan Caballero",
            BigDecimal.ZERO
        );
        assertEquals(BigDecimal.ZERO, accountService.getBalance("0110295202"),
            "La cuenta creada deberia pasar la validación");
    }

    @Test
    void shouldFailCreatingInvalidAccountEmail() {
        assertThrows(IllegalArgumentException.class,
            () -> accountService.createAccount(
                "0123542678",
                "mailfail",
                "Oscar Sanchez",
                BigDecimal.ZERO
            ),
            "Deberia fallar la creación de cuenta por el email"
        );
    }

    @Test
    void shouldFailCreatingInvalidAccount() {
        assertThrows(IllegalArgumentException.class,
            () -> accountService.createAccount(
                "9912345678",
                "robinson@gmail.com",
                "Robinson Portela",
                BigDecimal.ZERO
            ),
            "Deberia fallar ya que el número de la cuenta está mal"
        );
    }

    @Test
    void shouldFailCreatingInvalidAccountName() {
        assertThrows(IllegalArgumentException.class,
            () -> accountService.createAccount(
                "0235676549",
                "robinson@gmail.com",
                "",
                BigDecimal.ZERO
            ),
            "Deberia fallar porque no tiene nombre la cuenta"
        );
    }

    @Test
    void shouldDepositMoneyCorrectly() {
        accountService.createAccount(
            "0101234567",
            "juancaballero@mail.com",
            "Juan Caballero",
            BigDecimal.ZERO
        );
        accountService.deposit("0101234567", BigDecimal.valueOf(5000));
        assertEquals(BigDecimal.valueOf(5000), accountService.getBalance("0101234567"),
            "La prueba debe pasar si deposita dinero positivo y una cuenta que existe"
        );
    }

    @Test
    void shouldFailDepositOnNonExistingAccount() {
        assertThrows(IllegalArgumentException.class,
            () -> accountService.deposit("7873721932", BigDecimal.valueOf(100000)),
            "La prueba deberia fallar si al depositar la cuenta no existe"
        );
    }

    @Test
    void shouldFailDepositNegativeAmount() {
        accountService.createAccount(
            "0101234567",
            "juanCaballero@mail.com",
            "Juan Caballero",
            BigDecimal.ZERO
        );

        assertThrows(IllegalArgumentException.class,
            () -> accountService.deposit("0101234567", BigDecimal.valueOf(-802340)),
            "La prueba deberia fallar si al depositar se deposita un valor negativo"
        );
    }

    @Test
    void shouldFailCreatingDuplicateAccount() {
        accountService.createAccount(
            "0101234567",
            "juan@mail.com",
            "Juan Caballero",
            BigDecimal.ZERO
        );

        assertThrows(IllegalStateException.class,
            () -> accountService.createAccount(
                "0101234567",
                "maria@mail.com",
                "Mariana Acevedo",
                BigDecimal.ZERO
            ),
            "La prueba deberia fallar al intentar crear una cuenta con un ID ya existente"
        );  
    }
}