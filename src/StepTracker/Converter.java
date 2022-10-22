package StepTracker;

public class Converter{
    double oneStepByMeter   = 0.75; //один шаг равен 75 см
    int oneCalorieByStep = 50;  //1 шаг = 50 калорий
    double stepToKiloMetr(int step){
        return step*oneStepByMeter/1000;
    }
    double stepToKiloCalorie(int step){//возвращаем потраченные килокалории за шаги
        return (double) step*oneCalorieByStep/1000;
    }

}