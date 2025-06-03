import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashTable table1 = new HashTableHash1();
        HashTable table2 = new HashTableHash2();

        ArrayList<String> names = new ArrayList<>();
        String filePath = "female_names.txt"; // Ajuste o caminho se necessário

        // 🔹 Ler os nomes do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String name;
            while ((name = reader.readLine()) != null) {
                names.add(name);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            return;
        }

        // 🔸 Tempo de inserção - Tabela 1
        long startInsert1 = System.nanoTime();
        for (String name : names) {
            table1.insert(name);
        }
        long endInsert1 = System.nanoTime();
        long insertTime1 = endInsert1 - startInsert1;

        // 🔸 Tempo de inserção - Tabela 2
        long startInsert2 = System.nanoTime();
        for (String name : names) {
            table2.insert(name);
        }
        long endInsert2 = System.nanoTime();
        long insertTime2 = endInsert2 - startInsert2;

        // 🔹 Tempo de busca - Tabela 1
        long startSearch1 = System.nanoTime();
        for (String name : names) {
            table1.search(name);
        }
        long endSearch1 = System.nanoTime();
        long searchTime1 = endSearch1 - startSearch1;

        // 🔹 Tempo de busca - Tabela 2
        long startSearch2 = System.nanoTime();
        for (String name : names) {
            table2.search(name);
        }
        long endSearch2 = System.nanoTime();
        long searchTime2 = endSearch2 - startSearch2;

        // 🔥 Relatórios
        System.out.println("=== Tabela com Hash Function 1 ===");
        System.out.println("Número de colisões: " + table1.getCollisions());
        System.out.println("Tempo de inserção: " + insertTime1 / 1_000_000.0 + " ms");
        System.out.println("Tempo de busca: " + searchTime1 / 1_000_000.0 + " ms");
        table1.printDistribution();

        System.out.println("\n=== Tabela com Hash Function 2 ===");
        System.out.println("Número de colisões: " + table2.getCollisions());
        System.out.println("Tempo de inserção: " + insertTime2 / 1_000_000.0 + " ms");
        System.out.println("Tempo de busca: " + searchTime2 / 1_000_000.0 + " ms");
        table2.printDistribution();
    }
}
