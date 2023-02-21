package application;

import java.io.*;
import java.util.*;

public class CalculateMostRepeatedWords {

    public static void main(String[] args) {
        List<String> text = new ArrayList<>();

        // Read input from files
        readTextFromFile(args, text);

        // Read input from stdin
        readInputFromSTDIN(args, text);

        // Preprocess the text
        StringBuilder sb = getProcessedText(text);

        // Split the text into three-word sequences
        Map<String, Integer> frequencyMap = storeTreeWordsInHashMap(sb);

        // Sort the frequency map and print the top 100 most common three-word sequences
        sortByFrequencyAndPrint(frequencyMap);
    }

    private static void sortByFrequencyAndPrint(Map<String, Integer> frequencyMap) {
        List<Map.Entry<String, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        for (int i = 0; i < 100 && i < frequencyList.size(); i++) {
            Map.Entry<String, Integer> entry = frequencyList.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    private static Map<String, Integer> storeTreeWordsInHashMap(StringBuilder sb) {
        String[] words = sb.toString().split("\\s+");
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < words.length - 2; i++) {
            String threeWordSequence = words[i] + " " + words[i + 1] + " " + words[i + 2];
            frequencyMap.put(threeWordSequence, frequencyMap.getOrDefault(threeWordSequence, 0) + 1);
        }
        return frequencyMap;
    }

    private static StringBuilder getProcessedText(List<String> text) {
        StringBuilder sb = new StringBuilder();
        for (String line : text) {
            sb.append(line.replaceAll("[^a-zA-Z\\s]", "").toLowerCase());
            sb.append(" ");
        }
        return sb;
    }

    private static void readInputFromSTDIN(String[] args, List<String> text) {
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                text.add(scanner.nextLine());
            }
        }
    }

    private static void readTextFromFile(String[] args, List<String> text) {
        for (String arg : args) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arg))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    text.add(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading from file " + arg + ": " + e.getMessage());
            }
        }
    }
}
