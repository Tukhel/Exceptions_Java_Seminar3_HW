package Seminar_3_HW;

public class СheckAmountData extends RuntimeException{
    public СheckAmountData() {
        super("Введено неверное количество параметров");
    }

    public СheckAmountData(int count) {
        super("Необходимо ввести 4 параметра, вы ввели -> " + count);
    }
}