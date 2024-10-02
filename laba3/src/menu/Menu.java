package menu;

import battle.OneOnOneBattle;
import battle.TeamBattle;
import droids.BattleDroid;
import droids.Droid;
import droids.HealerDroid;
import droids.TankDroid;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Droid> droids = new ArrayList<>();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Показати список дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Командний бій");
            System.out.println("5. Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDroid(scanner);
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    startOneOnOneBattle(scanner);
                    break;
                case 4:
                    startTeamBattle(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Неправильний вибір.");
            }
        }
    }

    private void createDroid(Scanner scanner) {
        System.out.println("Виберіть тип дроїда:");
        System.out.println("1. Battle Droid");
        System.out.println("2. Healer Droid");
        System.out.println("3. Tank Droid");

        int type = scanner.nextInt();
        System.out.print("Введіть ім'я дроїда: ");
        String name = scanner.next();

        Droid droid;
        switch (type) {
            case 1:
                droid = new BattleDroid(name);
                break;
            case 2:
                droid = new HealerDroid(name);
                break;
            case 3:
                droid = new TankDroid(name);
                break;
            default:
                System.out.println("Невідомий тип.");
                return;
        }

        droids.add(droid);
        System.out.println("Дроїда створено.");
    }

    private void showDroids() {
        System.out.println("Список дроїдів:");
        for (Droid droid : droids) {
            System.out.println(droid.getName() + " (Здоров'я: " + droid.getHealth() + ", Урон: " + droid.getDamage() + ")");
        }
    }

    private void startOneOnOneBattle(Scanner scanner) {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою.");
            return;
        }

        showDroids();
        System.out.println("Виберіть двох дроїдів для бою 1 на 1:");

        System.out.print("Перший дроїд (номер): ");
        int droid1Index = scanner.nextInt();
        System.out.print("Другий дроїд (номер): ");
        int droid2Index = scanner.nextInt();

        Droid droid1 = droids.get(droid1Index - 1);
        Droid droid2 = droids.get(droid2Index - 1);

        OneOnOneBattle battle = new OneOnOneBattle(droid1, droid2);
        battle.startBattle();
    }

    private void startTeamBattle(Scanner scanner) {
        if (droids.size() < 4) {
            System.out.println("Недостатньо дроїдів для командного бою.");
            return;
        }

        List<Droid> team1 = new ArrayList<>();
        List<Droid> team2 = new ArrayList<>();

        System.out.println("Виберіть дроїдів для команди 1:");
        for (int i = 0; i < 2; i++) {
            showDroids();
            System.out.print("Виберіть дроїда (номер): ");
            int index = scanner.nextInt();
            team1.add(droids.get(index - 1));
        }

        System.out.println("Виберіть дроїдів для команди 2:");
        for (int i = 0; i < 2; i++) {
            showDroids();
            System.out.print("Виберіть дроїда (номер): ");
            int index = scanner.nextInt();
            team2.add(droids.get(index - 1));
        }

        TeamBattle battle = new TeamBattle(team1, team2);
        battle.startBattle();
    }
}
