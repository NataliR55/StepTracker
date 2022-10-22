package StepTracker;
import java.util.Scanner;
public class StepTracker {
    MonthData[] monthToData;
    private int planByDay;//план прохождения шагов за день
    public StepTracker() {
        planByDay = 10000;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void inputStepByMonth(int month, int day, int steps) {
         monthToData[month].putMonthData(day , steps);
    }
    public void printStatictic(int index) {//index - индекс месяца
        Converter converter = new Converter();
        System.out.println("*****************************");
        System.out.println("Статистика за "+index +" месяц:");
        System.out.println("---Количество пройденных шагов: ");
        monthToData[index].printAllStepByMonth();
        int SummaStep = monthToData[index].getSummaStepByMonth();
        System.out.println("---Общее количество шагов за месяц: " + SummaStep);
        System.out.println("---Максимально пройденное кол. шагов в месяце: " + monthToData[index].getMaxStepByMonth());
        System.out.println("---Среднее количество шагов: " + monthToData[index].getMidiStepOfMonth(SummaStep));
        System.out.println("---Пройденная дистанция: " + converter.stepToKiloMetr(SummaStep) + " км.");
        System.out.println("---Количество сожжённых килокалорий: " + converter.stepToKiloCalorie(SummaStep));
        System.out.println("---Лучшая серия лучше целевого("+planByDay +" шагов) " + monthToData[index].bestSeria(planByDay)+" дня.");
        System.out.println("*****************************");
    }
    public void putPlanByDay(int value){
        if (value>=0)        planByDay=value;
        else System.out.println("Ошибка! Введёное знанчение не может быть отрицательным!");
    }
    public void fillRandom() {//Для теста Заполнить месяц рандомными значениями шагов
        System.out.print("Введите номер месяца(от 0 до 11)>>");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if ((month >= 0) && (month <= 11)) monthToData[month].fillRandom(planByDay);
        else System.out.println("Не корректный ввод месяца для рандома!");
    }
}
