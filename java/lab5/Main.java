package lab5;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main() {
        System.out.println("Метод, возвращающий среднее значение списка целых чисел: ");
        List<Integer> list = new ArrayList<>();
        fillList(list);
        first(list);

        System.out.println("Метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»: ");
        List<String> strings = new ArrayList<>();
        fillString(strings);
        second(strings);

        System.out.println("Метод, возвращающий список квадратов всех встречающихся только один раз элементов списка: ");
        List<Integer> list2 = new ArrayList<>();
        fillList(list2);
        third(list2);

        System.out.println("Метод, принимающий на вход коллекцию строк и возвращает " +
                "все строки, начинающиеся с заданной буквы, отсортированные по алфавиту: ");
        List<String> strings2 = new ArrayList<>();
        fillString(strings2);
        fourth(strings2, 'r');

        System.out.println("Метод, принимающий на вход коллекцию и возвращающий " +
                "ее последний элемент или кидающий исключение, если коллекции пуста: ");
        List<Integer> list3 = new ArrayList<>();
        fillList(list3);
        fifth(list3);

        System.out.println("Метод, принимающий на вход массив целых чисел " +
                "возвращающий сумму чётных чисел или 0, если чётных чисел нет: ");
        Integer[] arr = new Integer[10];
        fillArr(arr);
        sixth(arr);

        System.out.println("Метод, преобразовывающий все строки в списке в Map, " +
                "где первый символ – ключ, оставшиеся – значение: ");
        List<String> strings3 = new ArrayList<>();
        fillString(strings3);
        seventh(strings3);
    }

    public static void first(List<Integer> list) {
        System.out.println(list.stream().mapToInt(Integer::intValue).average().orElse(0));
        System.out.println();
    }

    public static void second(List<String> list) {
        System.out.println(list.stream().map(String::toUpperCase).map(x -> "_new_" + x).toList());
        System.out.println();
    }

    public static void third(List<Integer> list) {
        System.out.println(list.stream().distinct().map(x -> x*x).toList());
        System.out.println();
    }

    public static void fourth(List<String> list, char c) {
        System.out.println(list.stream().filter(x -> x.startsWith(String.valueOf(c))).sorted().toList());
        System.out.println();
    }

    public static void fifth(Collection<?> collection) {
        try {
            System.out.println(collection.stream().reduce((first, second) -> second).orElseThrow(IllegalStateException::new));
            System.out.println();
        } catch (IllegalStateException e) {
            System.out.println("Коллекция пустая!");
        }
    }

    public static void sixth(Integer[] arr) {
        System.out.println(Arrays.stream(arr).filter(x -> x % 2 == 0).reduce(0, (acc, x) -> acc + x));
        System.out.println();
    }

    public static void seventh(List<String> list) {
        System.out.println(list.stream().map(String::toLowerCase).collect(Collectors.groupingBy(x -> x.charAt(0))));
        System.out.println();
    }

    public static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            list.add(random.nextInt(11));
        }
        System.out.println(list);
    }

    public static void fillString(List<String> list) {
        list.add("Maths");
        list.add("Physics");
        list.add("Biology");
        list.add("Geography");
        list.add("ICT");
        list.add("fhysical education");
        list.add("LiTeRaTuRe");
        list.add("HISTORY");
        list.add("russian LANGUAGE");
        list.add("rapper");
        list.add("rubish");
        System.out.println(list);
    }

    public static void fillArr(Integer[] arr) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            arr[i] = random.nextInt(11);
        }
        System.out.println( Arrays.toString(arr));
    }
}
