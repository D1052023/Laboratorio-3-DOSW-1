package edu.dosw.lab.agilismo.Reto3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EstimacionAutomatizada {
    public static void ejecutar3() {
        Scanner scanner = new Scanner(System.in);

        List<History> stories = Arrays.asList(
                new History(1,"Cliente","Como cliente, quiero consultar el saldo de mi cuenta, para saber cuánto dinero tengo disponible."),
                new History(2,"Cliente","Como cliente, quiero crear una cuenta bancaria, para poder acceder a los servicios financieros."),
                new History(3,"Cliente","Como cliente, quiero validar/verificar mi número de cuenta antes de crearla, para asegurar que tiene el formato correcto y pertenece a un banco registrado."),
                new History(4,"Cliente","Como cliente, quiero realizar depósitos en mi cuenta, para aumentar el saldo disponible."),
                new History(5,"Banco","Como banco, quiero proveer los códigos de cuenta válidos, para que el sistema pueda crear cuentas correctamente."),
                new History(6,"Banco","Como banco, quiero validar las transacciones realizadas en las cuentas, para garantizar que sean seguras y autorizadas.")
        );
        
        System.out.print("Ingrese número de integrantes que votan: ");
        int nMembers = readValidInteger(scanner);
        List<Member> members = new ArrayList<>();
        for (int i = 1; i <= nMembers; i++) {
            System.out.print("Nombre integrante " + i + ": ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) name = "Integrante-" + i;
            members.add(new Member(name));
        }


        VotingService votingService = new VotingService();
        PlanningPoker planning = new PlanningPoker(stories, members, votingService);
        planning.login(scanner);


        scanner.close();
        System.out.println("\nSesión finalizada.");
    }

    private static int readValidInteger(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int v = Integer.parseInt(input);
                if (v > 0) return v;
            } catch (NumberFormatException ignored) {}
            System.out.print("Número inválido. Intente de nuevo: ");
        }
    }
}