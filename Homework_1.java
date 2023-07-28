import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// Task 1

// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

// public class Homework_1 {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Enter float number: ");

//         while (CheckFloat(scanner)) {
//             System.out.println("Enter float number: ");
//             scanner.next();
//         }
//     }
    
//     private static boolean CheckFloat(Scanner sc) {
//         try {
//             Float num = sc.nextFloat();
//             System.out.println("Your float number is " + num);
//             return false;
//         } catch (InputMismatchException e) {
//             System.out.println("Wrong type!");
//         }

//         return true;
//     }
// }


// Task 2

// Если необходимо, исправьте данный код

// public static void task2() {
//     try {
//         int d = 1;
//         double catchedRes1 = intArray[8] / d;
//         System.out.println("catchedRes1 = " + catchedRes1);
//     } catch (ArithmeticException e) {
//         System.out.println("Catching exception: " + e);
//     } catch (IndexOutOfBoundsException ex) {       // Если массив в строчке double catchedRes1 = intArray[8] / d; меньше элементов
//         System.out.println("Массив выходит за пределы своего размера!");
//     }
// }


// Task 3

// Дан следующий код, исправьте его там, где требуется

// public class Homework_1 {

//     public static void main(String[] args) throws Exception {
//         try {
//             int a = 90;
//             int b = 3;
//             System.out.println(a / b);
//             printSum(23, 234);
//             int[] abc = { 1, 2 };
//             abc[3] = 9;
//         } catch (NullPointerException ex) {  //непрвильный порядок эксепшенов
//             System.out.println("Указатель не может указывать на null!");
//         } catch (IndexOutOfBoundsException ex) {
//             System.out.println("Массив выходит за пределы своего размера!");
//         } catch (Throwable ex) {
//             System.out.println("Что-то пошло не так...");
//         } 
//     }

//     public static void printSum(Integer a, Integer b) {
//         System.out.println(a + b);
//     }
// }
 

// Task 4

// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

// public class Homework_1 {

//     public static void main(String[] args) {
//         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//         System.out.println("Enter any line except empty");

//         try {
//             String result = reader.readLine();
//             if(result.equals("")) throw new RuntimeException("You cant leave the line empty");

//             System.out.println("Your line is " + result);
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }
// }