public class Converter {
    double stepsToKilometers(int steps){
        double kilometers = steps * 0.00075;
        return kilometers;
    }
    int stepsToKcal(int steps) {
        int cal = steps * 50;
        int kcal = cal/1000;
        return kcal;
    }
}
