public class StepTracker {
    MonthData[] monthToData;


    StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0;
             i < monthToData.length;
             i++)
            monthToData[i] = new MonthData();
    }
}
