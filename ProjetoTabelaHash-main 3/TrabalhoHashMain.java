import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TrabalhoHashMain {
    public static void main(String[] args) {
        HashTableHash1 table1 = new HashTableHash1();
        HashTableHash2 table2 = new HashTableHash2();

        String filePath = "/Users/stephanny.araujoicloud.com/Downloads/TrabalhoHash/src/female_names.txt"; // ajuste o caminho conforme seu arquivo

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String name;
            while ((name = br.readLine()) != null) {
                table1.insert(name);
                table2.insert(name);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        System.out.println("=== Tabela com Hash Function 1 ===");
        System.out.println("Número de colisões: " + table1.getCollisions());
        table1.printDistribution();

        System.out.println("\n=== Tabela com Hash Function 2 ===");
        System.out.println("Número de colisões: " + table2.getCollisions());
        table2.printDistribution();
    }
}
