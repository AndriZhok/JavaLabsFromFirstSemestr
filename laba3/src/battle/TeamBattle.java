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
    public String startBattle() {
        StringBuilder battleLog = new StringBuilder();
        battleLog.append("Починається командний бій!\n");

        Random random = new Random();

        while (teamIsAlive(team1) && teamIsAlive(team2)) {
            Droid attacker1 = team1.get(random.nextInt(team1.size()));
            Droid attacker2 = team2.get(random.nextInt(team2.size()));

            if (attacker1.isAlive() && attacker2.isAlive()) {
                attacker1.attack(attacker2);
                battleLog.append(attacker1.getName()).append(" атакує ").append(attacker2.getName()).append(". ")
                        .append(attacker2.getName()).append(" залишилось ").append(attacker2.getHealth()).append(" здоров'я.\n");

                if (attacker2.isAlive()) {
                    attacker2.attack(attacker1);
                    battleLog.append(attacker2.getName()).append(" атакує ").append(attacker1.getName()).append(". ")
                            .append(attacker1.getName()).append(" залишилось ").append(attacker1.getHealth()).append(" здоров'я.\n");
                }
            }

            team1.removeIf(droid -> !droid.isAlive());
            team2.removeIf(droid -> !droid.isAlive());
        }

        if (teamIsAlive(team1)) {
            battleLog.append("Команда 1 виграла!\n");
        } else {
            battleLog.append("Команда 2 виграла!\n");
        }

        System.out.println(battleLog.toString());
        return battleLog.toString();
    }

    private boolean teamIsAlive(List<Droid> team) {
        return team.stream().anyMatch(Droid::isAlive);
    }
}
