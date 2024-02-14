package lab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main() {
        run();
    }

    public static void run() {
        File mapFile = new File("java/lab4/map.txt");
        File testFile = new File("java/lab4/test.txt");
        try {
            if (!mapFile.exists() || !testFile.exists()) {
                throw new FileReadException();
            }
            try (BufferedReader mapReader = new BufferedReader(new FileReader(mapFile));
                 BufferedReader testReader = new BufferedReader(new FileReader(testFile))) {
                read(mapReader, testReader);
            }
        } catch (FileReadException e) {
            e.printMessage("Ошибка доступа к файлу!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(BufferedReader mapReader, BufferedReader testReader) {
        try {
            Map<String, String> map = new HashMap<>();
            String line;
            String[] words;
            while (mapReader.ready()) {
                line = mapReader.readLine().toLowerCase();
                words = line.split("\\s+\\|\\s+");
                if (words.length != 2 || words[0].equals("") || words[1].equals(""))
                    throw new InvalidFileFormatException();
                map.put(words[0], words[1]);
            }

            List<Map.Entry<String, String>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries, (o1, o2) -> o2.getKey().length() - o1.getKey().length());
//            Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {
//                @Override
//                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
//                    return o2.getValue().length() - o1.getValue().length();
//                }
//            });

            Map<String, String> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, String> entry : entries) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
//            for (String key : sortedMap.keySet()) {
//                System.out.println(key + " - " + sortedMap.get(key));
//            }
//            System.out.println();

            while (testReader.ready()) {
                line = testReader.readLine().toLowerCase();
                StringBuilder str = new StringBuilder();
                str.append(line);
                for (String key : sortedMap.keySet()) {
                    if (str.toString().contains(key)) {
                        str.replace(str.indexOf(key), str.indexOf(key) + key.length(), sortedMap.get(key));
                    }
                }
                if (str.toString().equals(line)) System.out.println(line + " - ");
                else System.out.println(line + " - " + str);
            }
        } catch (InvalidFileFormatException e) {
            e.printMessage("Ошибка чтения словаря");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}