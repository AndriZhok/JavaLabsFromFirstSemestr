package battle;

import droids.Droid;

import java.util.List;
import java.util.Random;

public class TeamBattle extends Battle {
    private List<Droid> team1;
    private List<Droid> team2;

    public TeamBattle(List<Droid> team1, List<Droid> team2) {
        this.team1 = team1;
        this.team2 = team2;
    }

    @Override
    public void startBattle() {
        System.out.println("Починається командний бій!");

        Random random = new Random();

        while (teamIsAlive(team1) && teamIsAlive(team2)) {
            Droid attacker1 = team1.get(random.nextInt(team1.size()));
            Droid attacker2 = team2.get(random.nextInt(team2.size()));

            if (attacker1.isAlive() && attacker2.isAlive()) {
                attacker1.attack(attacker2);
                if (attacker2.isAlive()) {
                    attacker2.attack(attacker1);
                }
            }

            printTeamHealth(team1, "Команда 1");
            printTeamHealth(team2, "Команда 2");
        }

        if (teamIsAlive(team1)) {
            System.out.println("Команда 1 виграла!");
        } else {
            System.out.println("Команда 2 виграла!");
        }
    }

    private boolean teamIsAlive(List<Droid> team) {
        return team.stream().anyMatch(Droid::isAlive);
    }

    private void printTeamHealth(List<Droid> team, String teamName) {
        System.out.println(teamName + " стан:");
        team.forEach(droid -> System.out.println(droid.getName() + " здоров'я: " + droid.getHealth()));
    }
}
