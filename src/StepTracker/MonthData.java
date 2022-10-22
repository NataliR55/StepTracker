package StepTracker;

public class MonthData {
    private int[] stepByDay=new int[30];     //фактическое прохождение шагов за день в течении месяца
    public void putMonthData(int index, int step){//index- индекс даты месяца, step - шаги
        stepByDay[index]=step;
    }

    public int getMidiStepOfMonth(int summaStep){//Возвращает среднее количество шагов в месяц
        int summaDay=stepByDay.length;
        return summaDay==0 ? 0 : (int) summaStep/summaDay;
    }

    public int getSummaStepByMonth(){//сумма шагов за месяц
        int summa=0;
        for(int i : stepByDay ) {
            summa=summa+i;
        }
        return summa;
    }
    public int getMaxStepByMonth(){//максимально пройденное кол. шагов в месяце
        int maxStep=0;
        for(int i=0; i< stepByDay.length; i++ ) {
            maxStep=maxStep>stepByDay[i] ? maxStep : stepByDay[i];
        }
        return maxStep;
    }
    public void printAllStepByMonth(){ //печатаем все шаги за месяц
        String strAllStep="";
        int lengthStepByDay=stepByDay.length;
        for(int i =0;  i< lengthStepByDay; i++ ) {
            System.out.print(" " + (i + 1) + " день: " + stepByDay[i]+(i == (lengthStepByDay - 1) ? "" : ","));
        }
        System.out.println();
    }
    public int bestSeria(int planByDay){
        int i =0,maxPeriod=0;
        int maxIndex=this.stepByDay.length-1;

        while(i<= maxIndex ){
            if(this.stepByDay[i]>=planByDay) {
                int currentPeriod = 1;

                if (i < maxIndex){
                    int j = i + 1;
                    while ((this.stepByDay[j] >= planByDay) && (j <= maxIndex)) {
                        currentPeriod++;
                        if (j < maxIndex) j++;
                        else break;
                    }
                    i = j;
                }
                maxPeriod=maxPeriod>currentPeriod?maxPeriod:currentPeriod;
            }
            i++;
        }
        return maxPeriod;
    }
    public void fillRandom(int maxValue){//установить шаги рандомно за весь месяц
            for(int i=0; i< stepByDay.length; i++ ) {
                stepByDay[i]=(int) (Math.random() * (maxValue + 2000));
            }
        }
}

