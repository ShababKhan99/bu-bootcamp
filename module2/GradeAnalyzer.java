import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");
        double average = calculateAverage(scores);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) < min) {
                min = scores.get(i);
            }
            if (scores.get(i) > max) {
                max = scores.get(i);
            }
        }

        writeReport(scores, average, min, max, "report.txt");

    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<Integer>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                try {
                    if (line.isEmpty()) {
                        continue;
                    }
                    int number = Integer.parseInt(line);
                    scores.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Could not read line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        double average = 0.0;
        double sum = 0.0;
        if (scores.isEmpty()) {
            return average;
        }

        for (int i = 0; i < scores.size(); i++) {
            sum = sum + scores.get(i);
        }

        average = sum / (scores.size());

        return average;
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
            double avg, int high, int low,
            String outputFile) {

        int counterA = 0, counterB = 0, counterC = 0, counterD = 0, counterF = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) < 60) {
                counterF++;
            } else if (scores.get(i) < 70 && scores.get(i) >= 60) {
                counterD++;
            } else if (scores.get(i) < 80 && scores.get(i) >= 70) {
                counterC++;
            } else if (scores.get(i) < 90 && scores.get(i) >= 80) {
                counterB++;
            } else {
                counterA++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(String.format("Total scores counted: %d%n%n", scores.size()));
            System.out.println(String.format("Total scores counted: %d%n%n", scores.size()));
            writer.write("");
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println(String.format("Average score: %.2f%n", avg));
            writer.write(String.format("Highest score: %d%n", high));
            System.out.println(String.format("Highest score: %d%n", high));
            writer.write(String.format("Lowest score: %d%n%n", low));
            System.out.println(String.format("Lowest score: %d%n%n", low));
            writer.write("");
            writer.write(String.format("Grade distribution: %n"));
            writer.write(String.format("A(90-100): %d%n", counterA));
            System.out.println(String.format("A(90-100): %d%n", counterA));
            writer.write(String.format("B(80-90): %d%n", counterB));
            System.out.println(String.format("B(80-90): %d%n", counterB));
            writer.write(String.format("C(70-80): %d%n", counterC));
            System.out.println(String.format("C(70-80): %d%n", counterC));
            writer.write(String.format("D(60-70): %d%n", counterD));
            System.out.println(String.format("D(60-70): %d%n", counterD));
            writer.write(String.format("F(below 60): %d", counterF));
            System.out.println(String.format("F(below 60): %d", counterF));
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}
