import java.util.Scanner;
public class Praktikum {
    public static void main(String[] args){
        Converter kcalAndKilometers = new Converter();
        MonthData data = new MonthData();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();
        while (command != 0) {
            int steps = 0;
            int day = 0;
            if (command == 1) {
                System.out.println("Введите месяц месяц от 1 - Январь до 12 - Декабрь");
                int month = scanner.nextInt();
                while (month < 1 || month > 12) {
                    System.out.println("Ошибка.Введите корректный номер от 1 до 12,где 1 - Январь  12 - Декабрь");
                    month = scanner.nextInt();
                }
                System.out.println("Введите день от 1 до 30");
                day = scanner.nextInt();
                while (day < 1 || day > 30) {
                    System.out.println("Ошибка.Введите корретный номер от 1 до 30");
                    day = scanner.nextInt();
                }
                System.out.println("Введите кол-во шагов");
                steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Ошибка.Введите значение больше -1");
                    steps = scanner.nextInt();
                }
                data.saveSteps(day, steps);
                System.out.println("Значение сохранено.");
            } else if (command == 2) {
                System.out.println("Выберите месяц от 1 - Январь до 12 - Декабрь");
                int month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.println("Ошибка.Введите корректный номер от 0 до 11,где 0 - Январь  11 - Декабрь");
                    month = scanner.nextInt();
                }
                printStepsPerMonth();
                System.out.println("Общее кол-во шагов за месяц " + data.allStepsInMonth());
                System.out.println("Максмальное количество шагов за месяц " + data.findMaxSteps());
                System.out.println("Среднее количество шагов за месяц " + data.findMeanSteps());
                System.out.println("Вы прошли " + kcalAndKilometers.stepsToKilometers(data.allStepsInMonth()) + " км");
                System.out.println("Вы сожгли " + kcalAndKilometers.stepsToKcal(data.allStepsInMonth()) + " килокалорий");
                System.out.println("Лучшая серия " + data.longestSeries(data.changeDefaultSteps(steps)) + " подряд");
            } else if (command == 3) {
                System.out.println("Изменить цель по кол-ву шагов в день.Введите значение больше -1");
                int targetSteps = scanner.nextInt();
                while (targetSteps < 0) {
                    System.out.println("Ошибка.Введите значение больше -1");
                    targetSteps = scanner.nextInt();
                }
                System.out.println("Вы изменили цель по кол-ву шагов.Новая цель - " + data.changeDefaultSteps(targetSteps));
            } else if (command == 4) {
                break;
            } else {
                System.out.println("Ошибка.Введите значение от 1 до 4");
            }
            printMenu();
            command = scanner.nextInt();
        }
    }

    private static void printMenu() {//Меню
        System.out.println("1.Введите кол-во шагов за определенный день");
        System.out.println("2.Напечатать статистику за определенный месяц");
        System.out.println("3.Изменить цель по кол-ву шагов в день");
        System.out.println("4.Выход");
    }

    public static void printStepsPerMonth() { //Напечатать шаги за месяц
        MonthData data = new MonthData();
        for (int i = 1; i < 31; i++) {
            System.out.println(i + " день.Пройдено " + data.getStepsPerDay(i) + " шагов");
        }
    }
}
