public class MonthData {

    int defaultSteps = 1000;
    int[] stepsPerDay ;

    MonthData() {
        stepsPerDay = new int[30];
    }
    int changeDefaultSteps(int targetSteps) { // Изменить значение шагов по умолчанию
        defaultSteps = targetSteps;
        return targetSteps;
    }
    void saveSteps(int day, int steps) { // Сохранить шаги
        stepsPerDay[day - 1] = stepsPerDay[day - 1] + steps;
    }
    public int getStepsPerDay(int day) { // Для правильного вывода шагов по дням
        return stepsPerDay[day - 1];
    }
    int findMaxSteps() { // Максимальное кол-ва шагов
        int maxSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            if (stepsPerDay[i] > maxSteps) maxSteps = stepsPerDay[i];
        }
        return maxSteps;
    }
    int findMeanSteps() { // Среднее кол-во шагов
        int allSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            allSteps = stepsPerDay[i] + allSteps;
        }
        allSteps = allSteps / stepsPerDay.length;
        return allSteps;
    }
    int allStepsInMonth() { // Общее кол-во шагов
        int totalSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            totalSteps = stepsPerDay[i] + totalSteps;
        }
        return totalSteps;
    }
    int longestSeries(int x) { // Лучшая серия
        int count = 0;

        int length = 0;

        for (int i = 0; i < stepsPerDay.length; i++) {

            if (stepsPerDay[i] > x) {
                count += 1;
            } else {

                length = Math.max(length, count);

                count = 0;
            }
        }

        if (count > 0)
            length = Math.max(length, count);

        return length;
    }
}
