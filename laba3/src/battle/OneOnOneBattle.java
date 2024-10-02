package battle;

import droids.Droid;

public class OneOnOneBattle extends Battle {
    private Droid droid1;
    private Droid droid2;

    public OneOnOneBattle(Droid droid1, Droid droid2) {
        this.droid1 = droid1;
        this.droid2 = droid2;
    }

    @Override
    public String startBattle() {
        StringBuilder battleLog = new StringBuilder();
        battleLog.append("Бій 1 на 1 між ").append(droid1.getName()).append(" і ").append(droid2.getName()).append("!\n");

        while (droid1.isAlive() && droid2.isAlive()) {
            droid1.attack(droid2);
            battleLog.append(droid1.getName()).append(" атакує ").append(droid2.getName()).append(". ")
                    .append(droid2.getName()).append(" залишилось ").append(droid2.getHealth()).append(" здоров'я.\n");

            if (droid2.isAlive()) {
                droid2.attack(droid1);
                battleLog.append(droid2.getName()).append(" атакує ").append(droid1.getName()).append(". ")
                        .append(droid1.getName()).append(" залишилось ").append(droid1.getHealth()).append(" здоров'я.\n");
            }
        }

        if (droid1.isAlive()) {
            battleLog.append(droid1.getName()).append(" виграв бій!\n");
        } else {
            battleLog.append(droid2.getName()).append(" виграв бій!\n");
        }

        System.out.println(battleLog.toString());
        return battleLog.toString();
    }
}
