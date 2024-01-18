package Seminar_3_HW;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;

public class Main {
    public static void main(String[] args) throws Exception {
        savingUser();
    }

    public static void savingUser() throws Exception {
        System.out.println(
                "Введите в одну строчку данные разделяя пробелом: " + 
                "ФИО(через запутяую) дата рождения(формат dd.mm.yyyy) " + 
                "номер телефона(через 8, без знаков и разделителей) " + 
                "пол(один символ м или ж)");
        String user;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        user = br.readLine();

        String[] arrText = user.split(" ");

        if(arrText.length != 4) {
            throw new СheckAmountData(arrText.length);
        }

        String[] arrFIO = arrText[0].split(",");

        if(arrFIO.length != 3) {
            throw new CheckFIO(arrFIO.length);
        }

        String lastname = arrFIO[0];
        String firstname = arrFIO[1];
        String patronymic = arrFIO[2];

        if (!IsValidFIO.isValid(arrFIO[0]) && !IsValidFIO.isValid(arrFIO[1]) && !IsValidFIO.isValid(arrFIO[2])) {
            throw new RuntimeException("Неверно введены данные ФИО");
        }

        String birthdate = arrText[1];
        if (!birthdate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalArgumentException("Неверный формат даты рождения");
        }

        Integer phone = null;
        try {
            if (Integer.parseInt(arrText[2]) == 11) {
                phone = Integer.parseInt(arrText[2]);
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("Неверный формат телефона");
        }

        String sex = arrText[3];
        if (!sex.toLowerCase().equals("f") && !sex.toLowerCase().equals("m")){
            throw new RuntimeException("Неверно введен пол");
        }

        String fileName = lastname + ".txt";
        File file = new File(fileName);
        file.createNewFile();
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", lastname, firstname, patronymic, birthdate, phone, sex));
        }catch (IOException e){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }

        System.out.println(lastname);
        System.out.println(lastname + " " + firstname + " " + patronymic + " " + birthdate + " " + phone + " " + sex);
        
    }

    

}


