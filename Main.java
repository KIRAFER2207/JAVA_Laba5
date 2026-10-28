import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
       Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)));
        // Колекція об'єктів нашого класу Student
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kira", 19, "126"));

        while (true) {
            System.out.println("\n=== МЕНЮ TASK 2 (I/O Streams) ===");
            System.out.println("1. Показати список студентiв");
            System.out.println("2. Додати нового студента");
            System.out.println("3. Зберегти колекцiю у файл");
            System.out.println("4. Завантажити колекцiю з файлу");
            System.out.println("0. Вихiд");
            System.out.print("Обери пункт меню: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очищення буфера пiсля введення числа

            switch (choice) {
                case 1:
                    System.out.println("\nПоточний список студентiв:");
                    if (students.isEmpty()) {
                        System.out.println("Список порожнiй.");
                    } else {
                        for (Student s : students) {
                            System.out.println("- " + s);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Введи iм'я студента: ");
                    String name = scanner.nextLine();
                    System.out.print("Введи вiк: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // очищення буфера
                    System.out.print("Введи спецiальнiсть: ");
                    String specialty = scanner.nextLine();

                    students.add(new Student(name, age, specialty));
                    System.out.println(" Студента успiшно додано!");
                    break;
                case 3:
                    System.out.print("Введи назву файлу для збереження: ");
                    String saveFile = scanner.nextLine();
                    FileManager.saveObject(saveFile, students);
                    break;
                case 4:
                    System.out.print("Введи назву файлу для завантаження: ");
                    String loadFile = scanner.nextLine();
                    Object loadedData = FileManager.loadObject(loadFile);
                    if (loadedData != null) {
                        students = (List<Student>) loadedData;
                        System.out.println("Данi успiшно оновлено в пам'ятi програми.");
                    }
                    break;
                case 0:
                    System.out.println("Вихiд з програми...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невiрний вибiр, спробуй ще раз.");
            }
        }
    }
}
