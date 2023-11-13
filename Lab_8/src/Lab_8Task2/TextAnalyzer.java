package Lab_8Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TextAnalyzer {
    // <word, its positions>
    private Map<String, ArrayList<Integer>> map = new HashMap<>();

    // Task 2.1
    public void add(String word, int position) {
        // Check if the word is already in the map
        if (map.containsKey(word)) {
            // Add the word position to the list of positions
            map.get(word).add(position);
        } else {
            // Create a new ArrayList for the word and add the position
            ArrayList<Integer> positions = new ArrayList<>();
            positions.add(position);
            map.put(word, positions);
        }
    }

    // Task 2.2
    public void displayWords() {
        TreeMap<String, ArrayList<Integer>> sortedMap = new TreeMap<>(map);

        System.out.println("Word\tWord Position(s)");
        System.out.println("===========================");
        for (Map.Entry<String, ArrayList<Integer>> entry : sortedMap.entrySet()) {
            System.out.print(entry.getKey() + "\t");
            for (int position : entry.getValue()) {
                System.out.print(position + ", ");
            }
            System.out.println();
        }
    }

    // Task 2.3
    public void displayText() {
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();
    }

    // Task 2.4
    public String mostFrequentWord() {
        String mostFrequent = null;
        int maxFrequency = 0;

        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            int frequency = entry.getValue().size();
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequent = entry.getKey();
            }
        }

        return mostFrequent;
    }

    // Task 2.5
    public void load(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    int position = (line.endsWith(word)) ? -lineNumber : lineNumber;
                    add(word, position);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.load("data/short.txt");
        textAnalyzer.displayWords();
        System.out.println("Most frequent word: " + textAnalyzer.mostFrequentWord());
        System.out.println("Text content: ");
        textAnalyzer.displayText();
    }
}

