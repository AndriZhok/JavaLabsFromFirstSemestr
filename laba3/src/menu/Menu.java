package menu;

import droids.Droid;
import droids.BattleDroid;
import droids.HealerDroid;
import droids.TankDroid;
import battle.OneOnOneBattle;
import battle.TeamBattle;
import utils.FileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private List<Droid> droids;

    public Menu() {
        scanner = new Scanner(System.in);
        droids = new ArrayList<>();
    }

    // Основний метод для запуску меню
    public void start() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очищення сканера

            switch (choice) {
                case 1:
                    createDroid();
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    startOneOnOneBattle();
                    break;
                case 4:
                    startTeamBattle();
                    break;
                case 5:
                    replayBattleFromFile();
                    break;
                case 0:
                    running = false;
                    System.out.println("Вихід з програми...");
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }

    // Виведення меню користувачеві
    private void printMenu() {
        System.out.println("\n=== Меню гри 'Битва Дроїдів' ===");
        System.out.println("1. Створити дроїда");
        System.out.println("2. Показати список створених дроїдів");
        System.out.println("3. Запустити бій 1 на 1");
        System.out.println("4. Запустити командний бій");
        System.out.println("5. Відтворити бій із файлу");
        System.out.println("0. Вийти з програми");
        System.out.print("Виберіть опцію: ");
    }

    // Метод для створення дроїда
    private void createDroid() {
        System.out.println("\nВиберіть тип дроїда:");
        System.out.println("1. Battle Droid (Атакувальний)");
        System.out.println("2. Healer Droid (Лікувальний)");
        System.out.println("3. Tank Droid (Танк)");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Очищення потоку

        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.nextLine();

        Droid newDroid;
        switch (choice) {
            case 1:
                newDroid = new BattleDroid(name);
                break;
            case 2:
                newDroid = new HealerDroid(name);
                break;
            case 3:
                newDroid = new TankDroid(name);
                break;
            default:
                System.out.println("Невірний вибір, дроїда не створено.");
                return;
        }

        droids.add(newDroid);
        System.out.println("Дроїда " + name + " створено.");
    }

    // Метод для показу списку дроїдів
    private void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("Немає створених дроїдів.");
        } else {
            System.out.println("Список дроїдів:");
            for (int i = 0; i < droids.size(); i++) {
                System.out.println((i + 1) + ". " + droids.get(i).getName() + " (HP: " + droids.get(i).getHealth() + ")");
            }
        }
    }

    // Метод для запуску бою 1 на 1
    private void startOneOnOneBattle() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою.");
            return;
        }

        showDroids();

        System.out.print("Виберіть першого дроїда: ");
        int index1 = scanner.nextInt() - 1;
        System.out.print("Виберіть другого дроїда: ");
        int index2 = scanner.nextInt() - 1;

        if (index1 >= 0 && index1 < droids.size() && index2 >= 0 && index2 < droids.size() && index1 != index2) {
            Droid droid1 = droids.get(index1);
            Droid droid2 = droids.get(index2);

            OneOnOneBattle battle = new OneOnOneBattle(droid1, droid2);
            String battleLog = battle.startBattle();

            System.out.println("Записати бій у файл? (1 - так, 0 - ні)");
            int saveChoice = scanner.nextInt();
            if (saveChoice == 1) {
                saveBattle(battleLog);
            }
        } else {
            System.out.println("Невірний вибір дроїдів.");
        }
    }

    // Метод для запуску командного бою
    private void startTeamBattle() {
        if (droids.size() < 4) {
            System.out.println("Недостатньо дроїдів для командного бою.");
            return;
        }

        showDroids();

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        System.out.println("Виберіть дроїдів для команди 1 (2 дроїда):");
        for (int i = 0; i < 2; i++) {
            int index = scanner.nextInt() - 1;
            team1.add(droids.get(index));
        }

        System.out.println("Виберіть дроїдів для команди 2 (2 дроїда):");
        for (int i = 0; i < 2; i++) {
            int index = scanner.nextInt() - 1;
            team2.add(droids.get(index));
        }

        TeamBattle teamBattle = new TeamBattle(team1, team2);
        String battleLog = teamBattle.startBattle();

        System.out.println("Записати бій у файл? (1 - так, 0 - ні)");
        int saveChoice = scanner.nextInt();
        if (saveChoice == 1) {
            saveBattle(battleLog);
        }
    }

    // Метод для збереження бою у файл
    private void saveBattle(String battleLog) {
        System.out.print("Введіть ім'я файлу для збереження бою: ");
        scanner.nextLine();  // Очищення потоку
        String filename = scanner.nextLine();

        FileHandler.saveToFile("resources/battle_logs/" + filename, battleLog);
        System.out.println("Бій збережено у файл " + filename);
    }

    // Метод для завантаження бою з файлу
    private void replayBattleFromFile() {
        System.out.print("Введіть ім'я файлу для завантаження бою: ");
        String filename = scanner.nextLine();

        String battleLog = FileHandler.loadFromFile("resources/battle_logs/" + filename);
        System.out.println("Відтворення бою з файлу:");
        System.out.println(battleLog);
    }
}
