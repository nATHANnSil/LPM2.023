import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class dataValida {
    public static void verificaData(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(data, formatter);
            System.out.println("A data é válida!");
        } catch (DateTimeParseException e) {
            System.out.println("A data é inválida!");
            System.out.println("Erro: " + e.getMessage());
        }
    }
}