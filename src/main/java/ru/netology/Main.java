package ru.netology;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static Collection<String> ORIGINAL_TEXT = new ArrayList<>();

    public static void main(String[] args) {
        getTextFromUser();
        sortWords(ORIGINAL_TEXT);

    }

    public static void getTextFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите полученный текст или пустое сообщение + enter для начала обработки");
        String text = scanner.nextLine();
            if (text != ("")) {
                ORIGINAL_TEXT.add(text);
                getTextFromUser();
            }
        scanner.close();
    }

    public static void sortWords (Collection<String> originalText) {
        Collection<String> collection = originalText;
        Arrays.stream(collection.stream()
                .flatMap((p) -> Arrays.asList(p.split(" ")) //create array from collection
                .stream())
                .toArray(String[]::new))
                .distinct()     //remove copyies
                .sorted()
                .forEach(s -> System.out.println(s));
    }
}


