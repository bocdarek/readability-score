package readability;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[0]);
        StringBuilder inputText = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            int i;
            while ((i = reader.read()) != -1) {
                inputText.append((char) i);
            }
        } catch (IOException e) {
            System.out.println("File not found!");
            return;
        }

        Text text = new Text(inputText.toString());

        System.out.println("The text is:");
        System.out.println(text.getText() + "\n");

        System.out.printf("Words: %d%n", text.words());
        System.out.printf("Sentences: %d%n", text.sentences());
        System.out.printf("Characters: %d%n", text.characters());
        System.out.printf("Syllables: %d%n", text.syllables());
        System.out.printf("Polysyllables: %d%n", text.polysyllables());


        List<String> algorithms = List.of("ari", "fk", "smog", "cl");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String command = sc.nextLine().trim().toLowerCase();
        System.out.println();

        if (algorithms.contains(command)) {
            Algorithm alg = Algorithm.getAlgorithm(command);
            if (alg != null) {
                alg.setText(text);
                String ageRange = alg.evaluateAgeRange();
                System.out.printf("This text should be understood by %s-year-olds.%n", ageRange);
            }
            return;
        }

        if (command.equals("all")) {
            double total = 0;
            for (String algorithm : algorithms) {
                Algorithm alg = Algorithm.getAlgorithm(algorithm);
                if (alg != null) {
                    alg.setText(text);
                    alg.printScore();
                    total += alg.getAverageAge();
                }
            }
            double avg = total / algorithms.size();
            System.out.printf("%nThis text should be understood in average by %.2f-year-olds.%n", avg);

        }
    }
}
