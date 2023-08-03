// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
// разделенные пробелом: Фамилия Имя Отчество датарождения номертелефона пол

// Форматы данных:
// фамилия, имя, отчество - строки
// датарождения - строка формата dd.mm.yyyy
// номертелефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение,
// что он ввел меньше и больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
// пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
// в него в одну строку должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Homework_3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Напишите ФИО, дату рождения, номер телефона и пол через пробел");
        String[] line = scanner.nextLine().split(" ");

        while (TypeCheck(scanner, line)) {
            System.out.println("Напишите ФИО, дату рождения, номер телефона и пол через пробел");
            line = scanner.nextLine().split(" ");
        }

        CreateAndWriteFile(line);

        scanner.close();
    }

    private static boolean TypeCheck(Scanner scan, String[] line) {
        try {
            if (line.length != 6) throw new WrongAmountException(line.length);

            String[] date = line[3].split("[.]");
            if (date.length != 3 || date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4) throw new IndexOutOfBoundsException();

            Integer.parseInt(line[4]);

            if (line[5].length() != 1 && (line[5].charAt(0) != 'f' || line[5].charAt(0) != 'm')) throw new WrongSexTypeException();

            return false;
        } catch (WrongAmountException e) {
            if (e.getNumber() > 6) System.out.println("Введено больше данных, чем требуется!");
            if (e.getNumber() < 6) System.out.println("Введено меньше данных, чем требуется!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неправильный формат даты, введите дату в формате dd.mm.yyyy!");
        } catch (NumberFormatException e) {
            System.out.println("Неправильный формат телефона! Правильный формат - целове беззнаковое число");
        } catch (WrongSexTypeException e) {
            System.out.println("Неправильынй формат пола! Введите пол символом f или m");
        }

        return true;
    }

    public static void CreateAndWriteFile(String[] line) {
        String surname = line[0];

        Path file = Paths.get(surname + ".txt");
        if (file.toFile().isFile()) {
            try {
                Scanner f = new Scanner(new File(surname + ".txt"));
                ArrayList<String> oldData = new ArrayList<String>();
                while (f.hasNextLine()){
                    oldData.add(f.nextLine());
                }
                f.close();
                System.out.println(oldData.get(0));
                oldData.add(String.join(" ", line));
                Files.write(file, oldData, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                List<String> lines = Arrays.asList(String.join(" ", line));
                Files.write(file, lines, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class WrongAmountException extends Exception {
        private int number;

        public int getNumber(){return number;}

        public WrongAmountException(int n) {
            super();
            number = n;
        }
    }

    static class WrongSexTypeException extends Exception {
        public WrongSexTypeException() {
            super();
        }
    }
}
