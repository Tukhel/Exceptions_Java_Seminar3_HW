package Seminar_3_HW;

public class CheckFIO extends RuntimeException {
    public CheckFIO() {
        super("Введено неверное количество параметров");
    }

    public CheckFIO(int count) {
        super("Необходимо ввести Фамилию, Имя, Отчество, вы ввели всего " + count + " параметр(а)");
    }
}
