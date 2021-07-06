package ru.netology;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Collection<String> originalText = new ArrayList<>();
        getTextFromUser(originalText);
        sortWords(originalText);
    }

    public static void getTextFromUser(Collection<String> originalText) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полученный текст или пустое сообщение + enter для начала обработки");
        String text = scanner.nextLine();
            if (text != ("")) {
                originalText.add(text);
                getTextFromUser(originalText);
            }
        scanner.close();
    }

    public static void sortWords (Collection<String> originalText) {
        originalText.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct()     //remove copyies
                .sorted()
                .forEach(s -> System.out.println(s));
    }
}


