package StepTracker;
//
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n"+"Вас приветствует программа: _-Счётчик калорий-_");
        System.out.println("------------------------------------------");
        StepTracker stepTracker = new StepTracker();
        Integer a=10;

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                    System.out.println("-----------");
                    System.out.print("Введите месяц ввода шагов(цифрами от 0 до 11)>>");

                    int month = scanner.nextInt();
                    if (month < 0 || month > 11) {
                        System.out.println("Не коректный ввод месяца: " + month + ". Должно быть от 0 до 11");
                        continue;
                    }
                    System.out.print("Введите день месяца(цифрами от 1 до 30)>>");
                    int day = scanner.nextInt();

                    if (day < 1 || day > 30) {
                        System.out.println("Не коректный ввод даты " + day + ". Дата должна быть в диапозоне от 1 до 30");
                        continue;
                    }
                    System.out.print("Введите шаги>>");
                    int steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Шаги не могут быть отрицательными!");
                        continue;
                    }
                    stepTracker.inputStepByMonth(month,day-1,steps);
            } else if (userInput == 2) {
                System.out.print("Введите интересуемый месяц статистики (от 0 до 11)>>");
                int userInputMonth = scanner.nextInt();
                if (userInputMonth < 0 || userInputMonth > 11) {
                    System.out.println("ВВедено недопустимое значение месяца!");
                } else {
                    stepTracker.printStatictic(userInputMonth );//передаем индекс месяца
                }
            } else if (userInput == 3) {//Изменение целевого количества шагов
                System.out.print("Введите введите плановое(целевое) количество шагов в день>>");
                int  steps= scanner.nextInt();
                stepTracker.putPlanByDay(steps);

            } else if (userInput == 4) {//выходим
                break;
            }else if (userInput == 9) {stepTracker.fillRandom();}// Заполняем рандомно месяц(тестовая)
            else {
                System.out.println("ВВедено недопустимое значение!");
            }
        }
        System.out.println("Всего доброго");
    }
    public static void printMenu() {
        System.out.println("Что бы вы хотели сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("4 - Выход.");
        System.out.println("9 - Заполнить какой-нибудь месяц произвольными значениями(для теста).");
        System.out.println("------------------------------------------");
        System.out.print("Введите от 1 до 4>>");
    }
}




