package utils;

import java.io.*;

public class FileHandler {

    public static void saveBattleLog(String fileName, String log) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(log);
        } catch (IOException e) {
            System.out.println("Помилка під час запису у файл.");
        }
    }

    public static String loadBattleLog(String fileName) {
        StringBuilder log = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                log.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Помилка під час читання з файлу.");
        }
        return log.toString();
    }
}
