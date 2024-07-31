import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void start() {
        space();
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("Введите задачу, которую хотите открыть(1, 2, 3)");
            System.out.println("Введите 0, чтобы закрыть программу");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    space();
                    System.out.println("Задача 1:");
                    task1();
                    break;
                case "2":
                    space();
                    System.out.println("Задача 2:");
                    System.out.println("Введите вашу операционную систему");
                    System.out.println("0 - IOS, 1 - Android");
                    int yourSystem = scanner.nextInt();
                    System.out.print("Введите год вашего устройства: ");
                    int yourYear = scanner.nextInt();
                    task2(yourSystem, yourYear);
                    break;
                case "3":
                    space();
                    System.out.println("Задача 3");
                    System.out.print("Введите количество км до вашего адреса: ");
                    int value = scanner.nextInt();
                    if(task3(value) == 1) {
                        System.out.println("Доставка в пределах 20 км занимает дней: " +  task3(value));
                    } else if (task3(value) == 2) {
                        System.out.println("Доставка в пределах от 20 км до 60 км км занимает дней: " +  task3(value));
                    } else if (task3(value) == 3) {
                        System.out.println("Доставка в пределах 60 км до 100 км занимает дней: " +  task3(value));
                    } else {
                        System.out.println("Доставка в пределах 100 км невозможна");
                    }
                    space();
                    break;
                case "0":
                    isAlive = false;
                    break;
                default:
                    System.out.println("Вы ввели неверное значение");
                    space();
                    break;
            }
        }
    }
    public static void space() {
        System.out.println("*******************************************************");
    }
    public static void task1() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Проверка года на високосный");
       System.out.print("Введите год: ");
       int thisYear = sc.nextInt();
        if (thisYear % 4 == 0 && thisYear >= 1584 && thisYear % 100 != 0 || thisYear % 400 == 0) {
            System.out.println(thisYear + " год высокосный");
        } else {
            System.out.println(thisYear + " год невысокосный");
        }
        space();
    }

    public static void task2(int osSystem, int yearDevice) {
        int currentYear = LocalDate.now().getYear();
        if (osSystem== 1 &&  yearDevice == currentYear) {
            System.out.println("Установите версию приложения для Android по ссылке");
        } else if (osSystem == 0 &&  yearDevice == currentYear) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else {
            System.out.println("Установите приложение по ссылке");
        }
        space();
    }

    public static int task3(int deliveryDistance) {
        if(deliveryDistance <= 20) {
            return 1;
        } else if (deliveryDistance <= 60) {
            return 2;
        } else if (deliveryDistance <= 100) {
            return 3;
        } else {
           return 4;
        }
    }

    public static void end() {
        System.out.println("До свидания!");
    }

    public static void main(String[] args) {
        start();
        end();
    }
}
