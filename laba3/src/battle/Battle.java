package battle;

import droids.Droid;

public abstract class Battle {
    public abstract String startBattle();

    public void attack(Droid attacker, Droid opponent) {
        opponent.setHealth(opponent.getHealth() - attacker.getDamage());
    }

    public void heal(Droid healer, Droid ally) {
        System.out.println(healer.getName() + " зцілює " + ally.getName() + " на 15 одиниць здоров'я.");
        ally.setHealth(ally.getHealth() + 15);
    }
}