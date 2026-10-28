import java.io.*;

public class FileManager {

    // Метод для збереження будь-якого об'єкта (наприклад, колекції) у файл
    public static void saveObject(String filename, Object data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
            System.out.println(" Данi успiшно збережено у файл: " + filename);
        } catch (IOException e) {
            System.out.println(" Помилка збереження файлу: " + e.getMessage());
        }
    }

    // Метод для читання об'єкта з файлу
    public static Object loadObject(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            System.out.println(" Данi успiшно завантажено з файлу: " + filename);
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" Помилка читання файлу: " + e.getMessage());
            return null;
        }
    }
}
