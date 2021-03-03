package main;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookReview {
    private final File file;
    private final static String SPLIT_REGEX = "[!@#$%&*'(…)ОXIV^€№§+ 0123456789„’—+-=-_“?/«»>°<.,{}`~|\n;:\"\\[\\]\\s+]";
    private final Map<String, Integer> mapWithWords;

    public BookReview(File file) {
        this.file = file;
        mapWithWords = new HashMap<>();
    }

    public void countWords(BufferedReader reader) throws IOException {
        long countWords = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] lineWords = line.split(BookReview.SPLIT_REGEX);
            for (String word : lineWords) {
                if (!word.equals("") && !word.equals(" ")) {
                    //System.out.print(word + " ");
                    countWords++;
                }
                //System.out.println();
            }
        }
        reader.close();

        System.out.println("Number of Words: " + countWords);
    }

    public void countLines(BufferedReader reader) throws IOException {
        int countLines = 0;

        while (reader.readLine() != null) {
            countLines++;
        }
        reader.close();

        System.out.println("Number of Lines: " + countLines);
    }

    public void countCommas(BufferedReader reader) throws IOException {
        int countCommas = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    countCommas++;
                }
            }
        }
        reader.close();

        System.out.println("Number of Commas: " + countCommas);
    }

    public void compareWords(BufferedReader reader) throws IOException {
        int countWar = 0;
        int countPeace = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            String[] lineWords = line.split(BookReview.SPLIT_REGEX);
            for (String word : lineWords) {
                if (word.startsWith("война")) {
                    countWar++;
                }
                if (word.equals("мир") || word.equals("мира") || word.equals("мирът") || word.equals("мирните")) {
                    countPeace++;
                }
            }
        }
        reader.close();

        System.out.println("Война се съдържа - " + countWar + " пъти");
        System.out.println("Мир се съдържа - " + countPeace + " пъти");
    }

    public void putWordsInMap() throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(this.file));

        while ((line = reader.readLine()) != null) {
            String[] lineWords = line.split(BookReview.SPLIT_REGEX);
            for (String word : lineWords) {
                if (!word.equals("") && !word.equals(" ")) {
                    if (!mapWithWords.containsKey(word)) {
                        mapWithWords.put(word, 1);
                    } else {
                        mapWithWords.put(word, mapWithWords.get(word) + 1);
                    }
                }
            }
        }
        reader.close();
    }

    public void mostCommonWord() {
        mapWithWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1)
                .forEach(e -> System.out.println("Most common Word: " + e.getKey() + " - " + e.getValue()));
    }

    public void getTenMostCommonWords() {
        System.out.println("Most common Words:");
        mapWithWords.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }

    public void getAndSortWordsByLengthAndName() throws IOException {
        List<String> sortedList = mapWithWords.keySet().stream().sorted().collect(Collectors.toList());

        BufferedWriter writer;
        for (String word : sortedList) {
            int length = word.length();
            File file = new File(length + "-буквени.txt");

            if (file.exists()) {
                writer = new BufferedWriter(new FileWriter(length + "-буквени.txt", true));
            } else {
                writer = new BufferedWriter(new FileWriter(file));
            }
            writer.write(word);
            writer.newLine();

            writer.close();
        }
    }

    public void viewReview() {
        try {
            putWordsInMap();
            countLines(new BufferedReader(new FileReader(this.file)));
            countWords(new BufferedReader(new FileReader(this.file)));
            countCommas(new BufferedReader(new FileReader(this.file)));
            mostCommonWord();
            getTenMostCommonWords();
            compareWords(new BufferedReader(new FileReader(this.file)));
            getAndSortWordsByLengthAndName();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}