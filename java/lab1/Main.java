package lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();

        int number = Integer.parseInt(args[0]);

        switch (number) {
            case 1:
                hero.setMoveStrategy(new Walking());
                hero.startMoving();
                break;
            case 2:
                hero.setMoveStrategy(new Riding());
                hero.startMoving();
                break;
            case 3:
                hero.setMoveStrategy(new Flying());
                hero.startMoving();
                break;
            case 4:
                hero.setMoveStrategy(new Driving());
                hero.startMoving();
                break;
            default:
                return;
        }

//        try (Scanner scanner = new Scanner(System.in)) {
//            while (true) {
//                System.out.println("Выберите стратегию: \n1: Walking \n2: Riding \n3: Flying \n4: Driving \nЛюбая другая клавиша: Закончить выполнение программы\n");
//                if (scanner.hasNextInt()) {
//                    number = scanner.nextInt();
//                    switch (number) {
//                        case 1:
//                            hero.setMoveStrategy(new Walking());
//                            hero.startMoving();
//                            break;
//                        case 2:
//                            hero.setMoveStrategy(new Riding());
//                            hero.startMoving();
//                            break;
//                        case 3:
//                            hero.setMoveStrategy(new Flying());
//                            hero.startMoving();
//                            break;
//                        case 4:
//                            hero.setMoveStrategy(new Driving());
//                            hero.startMoving();
//                            break;
//                        default:
//                            return;
//                    }
//                } else break;
//             }
//        }
    }
}
