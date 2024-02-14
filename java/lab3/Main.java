package lab3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main() {
        System.out.println("segregate(Mammals, Hedgehogs, Feline, Predatory)");
        test1();
        System.out.println();
        System.out.println("segregate(Predatory, Chordal, Manul, Feline)");
        test2();
        System.out.println();
        System.out.println("segregate(Hedgehogs, Insectivores, Predatory, Predatory)");
        test3();
    }

    private static void test3() {
        List<Insectivores> collection1 = new ArrayList<>();
        List<Predatory> collection2 = new ArrayList<>();
        List<Predatory> collection3 = new ArrayList<>();

        List<Hedgehogs> src = Arrays.asList(new CommonHedgehog(), new CommonHedgehog(), new CommonHedgehog(), new CommonHedgehog());

        segregate(src, collection1, collection2, collection3);

        System.out.println(collection1);
        System.out.println(collection2);
        System.out.println(collection3);

    }

    private static void test2() {
        List<Chordal> collection1 = new ArrayList<>();
        List<Manul> collection2 = new ArrayList<>();
        List<Feline> collection3 = new ArrayList<>();

        List<Predatory> src = Arrays.asList(new Lynx(), new Manul(), new Manul(), new Lynx());

        segregate(src, collection1, collection2, collection3);

        System.out.println(collection1);
        System.out.println(collection2);
        System.out.println(collection3);

    }

    private static void test1() {
        List<Mammals> src = Arrays.asList(new CommonHedgehog(), new Lynx(), new Manul(), new Manul(),
                new CommonHedgehog(), new Lynx());
        List<Hedgehogs> collection1 = new ArrayList<>();
        List<Feline> collection2 = new ArrayList<>();
        List<Predatory> collection3 = new ArrayList<>();

        segregate(src, collection1, collection2, collection3);

        System.out.println(collection1);
        System.out.println(collection2);
        System.out.println(collection3);

    }

    public static void segregate(Collection<? extends Mammals> srcCollection,
                                 Collection<? super Hedgehogs> collection1,
                                 Collection<? super Manul> collection2,
                                 Collection<? super Feline> collection3) {
        for (Mammals mammal : srcCollection) {
            if (mammal instanceof Hedgehogs) {
                collection1.add((Hedgehogs) mammal);
            }
            if (mammal instanceof Manul) {
                collection2.add((Manul) mammal);
            }
            if (mammal instanceof Lynx) {
                collection3.add((Lynx) mammal);
            }
        }
    }


}
