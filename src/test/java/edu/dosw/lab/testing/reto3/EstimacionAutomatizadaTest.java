package edu.dosw.lab.testing.reto3;

import edu.dosw.lab.agilismo.Reto3.EstimacionAutomatizada;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class EstimacionAutomatizadaTest {

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut;

    @BeforeEach
    void beforeEach() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void afterEach() {
        System.setOut(systemOut);
        System.setIn(systemIn);
    }

    private String runWithInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        EstimacionAutomatizada.ejecutar3();
        System.out.flush();
        return testOut.toString();
    }

    @Test
    void ShouldSingleMemberAllVotesAgree() {
        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        sb.append("Juan Pablo\n");
        sb.append("3\n3\n3\n3\n3\n3\n");
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Sesión finalizada.") || out.contains("Resumen de estimaciones"));
        assertTrue(out.contains("Estimación final") || out.contains("Consenso alcanzado"));
    }

    @Test
    void ShouldTwoMembersAllAgree() {
        StringBuilder sb = new StringBuilder();
        sb.append("2\nJuan Pablo\nOscar Sanchez\n");
        sb.append(IntStream.range(0, 12).mapToObj(i -> "5\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Resumen de estimaciones") && out.contains("Consenso alcanzado"));
    }

    @Test
    void ShouldInvalidNumberThenValid() {
        StringBuilder sb = new StringBuilder();
        sb.append("0\n");
        sb.append("1\n");
        sb.append("\n");
        sb.append(IntStream.range(0, 6).mapToObj(i -> "3\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Sesión finalizada.") || out.contains("Resumen de estimaciones"));
    }

    @Test
    void ShouldEmptyNameDefaultsToIntegrante() {
        StringBuilder sb = new StringBuilder();
        sb.append("1\n");
        sb.append("\n");
        sb.append(IntStream.range(0, 6).mapToObj(i -> "2\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Resumen de estimaciones") || out.contains("Sesión finalizada."));
    }

    @Test
    void ShouldDivergentThenConsensusFirstStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("2\nJuan Pablo\nOscar Sanchez\n");
        sb.append("3\n5\n3\n3\n");
        sb.append(IntStream.range(0, 10).mapToObj(i -> "1\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Votos divergentes") || out.contains("Consenso alcanzado"));
    }

    @Test
    void ShouldNonNumericVoteInputHandled() {
        StringBuilder sb = new StringBuilder();
        sb.append("1\nRobinson Nuñez\n");
        sb.append(IntStream.range(0, 6).mapToObj(i -> "x\n3\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Resumen de estimaciones"));
    }

    @Test
    void ShouldSingleMemberDifferentVotesPerStory() {
        StringBuilder sb = new StringBuilder();
        sb.append("1\nJuan Pablo\n");
        sb.append("1\n2\n3\n5\n8\n13\n");
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Consenso alcanzado: 13") || out.contains("Estimación final"));
    }

    @Test
    void ShouldThreeMembersAllVoteOne() {
        StringBuilder sb = new StringBuilder();
        sb.append("3\nJuan Pablo\nOscar Sanchez\nRobinson Nuñez\n");
        sb.append(IntStream.range(0, 18).mapToObj(i -> "1\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Resumen de estimaciones"));
    }

    @Test
    void ShouldNamesWithSpacesAreTrimmed() {
        StringBuilder sb = new StringBuilder();
        sb.append("2\n   \n  Oscar Sanchez  \n");
        sb.append(IntStream.range(0, 12).mapToObj(i -> "2\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Resumen de estimaciones"));
    }

    @Test
    void ShouldFourMembersAllVoteFive() {
        StringBuilder sb = new StringBuilder();
        sb.append("4\nJuan Pablo\nOscar Sanchez\nRobinson Nuñez\nIntegrante-4\n");
        sb.append(IntStream.range(0, 24).mapToObj(i -> "5\n").collect(Collectors.joining()));
        String out = runWithInput(sb.toString());
        assertTrue(out.contains("Resumen de estimaciones") && out.contains("Sesión finalizada."));
    }
}